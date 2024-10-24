package com.hdfc.eventpublisher;

import com.hdfc.events.Event;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.config.SslConfigs;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

@Configuration
@PropertySource("classpath:/event-publisher.properties")
@EnableAsync
@ConditionalOnProperty(name = "kmb.kafka.event.publisher.enabled", havingValue = "true")
public class KafkaEventPublisherConfig {

    @Value("${spring.kafka.producer.bootstrap-servers}")
    private String bootstrapServers;
    @Value("${spring.kafka.producer.properties.max.block.ms}")
    private int maxBlockMs;
    @Value("${spring.kafka.ssl.trust-store-location}")
    private String trustStoreLocation;
    @Value("${spring.kafka.producer.security.protocol}")
    private String protocol;

    @Value("${spring.kafka.thread-pool.core.size}")
    private int kafkaThreadPoolCoreSize;

    @Value("${spring.kafka.thread-pool.max.size}")
    private int kafkaThreadPoolMaxSize;

    @Value("${spring.kafka.thread-pool.queue.size}")
    private int kafkaThreadPoolQueueSize;

    @Bean(name = "eventPublisherThreadExecutor")
    public Executor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(kafkaThreadPoolCoreSize);
        executor.setMaxPoolSize(kafkaThreadPoolMaxSize);
        executor.setQueueCapacity(kafkaThreadPoolQueueSize);
        executor.setThreadNamePrefix("EventPublisher-");
        executor.setTaskDecorator(runnable -> {
            Map<String, String> copy = MDC.getCopyOfContextMap();
            return () -> {
                try {
                    MDC.setContextMap(copy);
                    runnable.run();
                } finally {
                    MDC.clear();
                }
            };
        });
        return executor;
    }

    @Bean
    public ProducerFactory<String, Event> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    @Bean
    @Profile("!test")
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        props.put(ProducerConfig.MAX_BLOCK_MS_CONFIG, maxBlockMs);
        props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, protocol);
        props.put(SslConfigs.SSL_TRUSTSTORE_LOCATION_CONFIG, trustStoreLocation);
        return props;
    }

    @Bean
    public KafkaTemplate<String, Event> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

}
