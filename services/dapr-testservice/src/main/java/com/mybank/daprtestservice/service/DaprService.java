package com.mybank.daprtestservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mybank.daprtestservice.domain.entity.MyEntity;
import com.mybank.daprtestservice.domain.request.LoginEntityRequest;
import com.mybank.daprtestservice.domain.request.MyEntityRequest;
import com.mybank.daprtestservice.domain.response.LoginEntityResponse;
import com.mybank.daprtestservice.domain.response.MyEntityResponse;
import com.mybank.daprtestservice.repository.MyEntityRepository;
import io.dapr.Topic;
import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;
import io.dapr.client.domain.CloudEvent;
import io.dapr.client.domain.HttpExtension;
import io.dapr.client.domain.Metadata;
import io.dapr.client.domain.State;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static java.util.Collections.singletonMap;

import java.util.Random;

@Service
@Slf4j
public class DaprService {
    @Autowired
    private MyEntityRepository myentityRepository;
    private DaprClient daprClient;
    private static final String STATE_STORE_NAME = "statestore";
    private static final   String MESSAGE_TTL_IN_SECONDS = "1000";
    private static final  String TOPIC_NAME = "orders";
    private static final String PUBSUB_NAME = "order-pub-sub";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    public MyEntityResponse create(MyEntityRequest request) {
        Random random = new Random();
        int orderId = random.nextInt(1000 - 1) + 1;
        daprClient = new DaprClientBuilder().build();
        log.info("daprClient obj {}", daprClient);
        daprClient.publishEvent(PUBSUB_NAME, TOPIC_NAME, orderId,
                singletonMap(Metadata.TTL_IN_SECONDS, MESSAGE_TTL_IN_SECONDS)).block();
        log.info("pubished obj {}", orderId);
        var saved = this.myentityRepository.save(new MyEntity(request.title(), request.isActive()));
        return new MyEntityResponse(saved.getId(), saved.getTitle(), saved.isActive());
    }


    @Topic(name = "orders", pubsubName = "order-pub-sub")
    public Mono<String> getCheckout(CloudEvent<String> cloudEvent) {
        return Mono.fromRunnable(() -> {
            try {
                String rec  = cloudEvent.getData();
                log.info("Subscriber received {} ", rec);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
    public String serviceToService(LoginEntityRequest loginEntityRequest) {
        String res  = "";
        try {
           daprClient = new DaprClientBuilder().build();
           log.info("daprClient obj {}", daprClient);
           LoginEntityResponse resObj = daprClient.invokeMethod("login-service-app", "loginentity", loginEntityRequest,
                   HttpExtension.POST, LoginEntityResponse.class).block();
            log.info("daprClient res obj {}", resObj);
           res  = OBJECT_MAPPER.writeValueAsString(resObj);
           log.info("daprClient res {}", res);
       } catch (Exception e) {
         e.printStackTrace();
       }
        return res;
    }

    public String saveStore() {
        daprClient = new DaprClientBuilder().build();
        log.info("daprClient obj {}", daprClient);
        int orderId =  123;
        daprClient.saveState(STATE_STORE_NAME, "order_1",
                Integer.toString(orderId)).block();
        return "saved store object..";
    }

    public String getStore() {
        daprClient = new DaprClientBuilder().build();
        log.info("daprClient obj {}", daprClient);
        State<String> result = daprClient.getState(STATE_STORE_NAME, "order_1",
                String.class).block();
        log.info("daprClient result obj {}", result);
        assert result != null;
        return result.getValue();
    }
}
