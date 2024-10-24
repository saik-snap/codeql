package com.hdfc.eventpublisher;

import com.hdfc.events.Event;
import com.hdfc.events.KafkaTopic;
import org.springframework.scheduling.annotation.Async;

public interface EventPublisher {

    @Async("eventPublisherThreadExecutor")
    default <EventData> void publishAsync(KafkaTopic topic, String key, Event event) {
        this.publish(topic, key, event);
    }

    @Async("eventPublisherThreadExecutor")
    default <EventData> void publishAsync(String topic, String key, Event event) {
        this.publish(topic, key, event);
    }

    default <EventData> void publish(KafkaTopic topic, String key, Event event) {
        this.publish(topic.getTopicName(), key, event);
    }

    <EventData> void publish(String topic, String key, Event event);

    default <EventData> void publish(String topic, Event event) {
        this.publish(topic, null, event);
    }
}
