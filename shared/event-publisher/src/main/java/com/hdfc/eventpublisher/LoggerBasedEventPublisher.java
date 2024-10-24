package com.hdfc.eventpublisher;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hdfc.events.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@ConditionalOnProperty(name = "kmb.kafka.event.publisher.enabled", havingValue = "false", matchIfMissing = true)
class LoggerBasedEventPublisher implements EventPublisher {
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public <EventData> void publish(String topic, String key, Event event) {
        String eventJson = null;
        try {
            eventJson = objectMapper.writeValueAsString(event);
        } catch (JsonProcessingException e) {
            log.info("EventData Json-parsing error");
        }
        log.info("Publishing event {} with key {} to topic {}", eventJson, key, topic);
    }
}
