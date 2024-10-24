package com.hdfc.eventpublisher;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {EventPublisherConfig.class})
@TestPropertySource(properties = "kmb.kafka.event.publisher.enabled=false", locations = "classpath:/application-test" +
        ".properties")
class LoggerBasedEventPublisherTest {

    @Autowired
    private EventPublisher eventPublisher;
}