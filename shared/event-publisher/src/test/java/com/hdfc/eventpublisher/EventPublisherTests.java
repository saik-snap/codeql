package com.hdfc.eventpublisher;

import com.hdfc.events.Event;
import com.hdfc.events.KafkaTopic;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {EventPublisherConfig.class, ConsumerConfig.class, TestAsyncConfiguration.class})
@DirtiesContext
@EmbeddedKafka(partitions = 1,
        brokerProperties = {"listeners=PLAINTEXT://localhost:${test.kafka.random.port}", "port=${test.kafka.random" +
                ".port}"})
@TestPropertySource(locations = "classpath:/application-test.properties")
@ActiveProfiles("test")
class EventPublisherTests {

    @SpyBean
    private KafkaTemplate<String, Event> kafkaTemplate;
    @Autowired
    private EventPublisher eventPublisher;
    @Autowired
    private KafkaConsumer consumer;
    @Value("${service.kafka.topic}")
    private String topic;

    @Test
    void event_publisher_is_not_null() {
        assertThat(eventPublisher).isNotNull();
    }

    @Test
    void should_send_and_receive_a_message() throws Exception {
        Event event = Event.<Map<String, String>>builder()
                .source("/customers")
                .type("com.customer.registered")
                .data(null)
                .build();
        eventPublisher.publishAsync(this.topic, "c1", event);
        consumer.getLatch().await(10, TimeUnit.SECONDS);

        assertThat(consumer.getLatch().getCount()).isZero();
        assertThat(consumer.getPayload()).contains(this.topic);
    }

    @Test
    void should_send_and_receive_a_message_enum_topic() throws Exception {
        Event event = Event.<Map<String, String>>builder()
                .source("/customers")
                .type("com.customer.registered")
                .data(null)
                .build();

        eventPublisher.publishAsync(KafkaTopic.AUDIT_EVENTS, "c1", event);
        consumer.getLatch().await(10, TimeUnit.SECONDS);

        assertThat(consumer.getLatch().getCount()).isZero();
        assertThat(consumer.getPayload()).contains(this.topic);
    }

    @Test
    void should_handle_kafka_exception() {
        Event event = Event.<Map<String, String>>builder()
                .source("/customers")
                .type("com.customer.registered")
                .data(null)
                .build();
        doThrow(new KafkaException("Failed")).when(kafkaTemplate).send(this.topic , event);
        eventPublisher.publish(this.topic, event);
        verify(kafkaTemplate).send(this.topic, event);
    }
}

@TestConfiguration
class TestAsyncConfiguration {

    @Value("${spring.kafka.producer.bootstrap-servers}")
    private String bootstrapServers;
    @Value("${spring.kafka.producer.properties.max.block.ms}")
    private int maxBlockMs;

    @Bean(name = "eventPublisherThreadExecutor")
    public Executor threadPoolTaskExecutor() {
        return new SyncTaskExecutor();
    }

    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, maxBlockMs);
        props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "PLAINTEXT");
        return props;
    }
}
