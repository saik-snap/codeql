package com.hdfc.eventpublisher;

import com.hdfc.events.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
@Slf4j
@ConditionalOnProperty(name = "kmb.kafka.event.publisher.enabled", havingValue = "true")
class KafkaBasedEventPublisher implements EventPublisher {

    @Autowired
    private KafkaTemplate<String, Event> kafkaTemplate;

    @Override
    public  void publish(String topic, String key, Event event) {
        try {
            String eventId = event.getId();
            log.info("Sending event [id={},key={},topic={}]", eventId, key, topic);
            ListenableFuture<SendResult<String, Event>> future;
            if (key == null) {
                future = this.kafkaTemplate.send(topic, event);
            } else {
                future = this.kafkaTemplate.send(topic, key, event);
            }
            future.addCallback(
                    (result) -> log.info("Received success response for event with id {} to topic {}. Response is {}",
                            eventId, topic, result),
                    (exception) -> log.error("Received failure when sending event with id {} to topic {}. Exception " +
                                    "is {}",
                            eventId, topic, exception.getMessage(), exception));

            log.info("Sent event with id {} to topic {}", eventId, topic);
        } catch (Exception e) {
            String message = e.getMessage();
            log.error("Exception while writing event {} to Kafka. Exception message {}", event.getId(), message, e);
        }
    }

}