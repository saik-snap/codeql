package com.hdfc.events;

public enum KafkaTopic {
    AUDIT_EVENTS(Constants.AUDIT_TOPIC),
    INIT_SERVICE_EVENTS(Constants.INIT_SERVICE_TOPIC),
    MAINTENANCE_SERVICE_EVENTS(Constants.MAINTENANCE_SERVICE_TOPIC),
    APP_SERVICE_EVENTS(Constants.APP_SERVICE_TOPIC),
    NOTIFICATION_SERVICE_EVENTS(Constants.NOTIFICATION_SERVICE_TOPIC),
    TRANSACTION_SERVICE_EVENTS(Constants.TRANSACTION_SERVICE_TOPIC),
    UPI_SERVICE_EVENTS(Constants.UPI_SERVICE_TOPIC),
    CUSTOMER_SERVICE_EVENTS(Constants.CUSTOMER_SERVICE_TOPIC),
    CUSTOMER_VERIFICATION_SERVICE_EVENTS(Constants.CUSTOMER_VERIFICATION_SERVICE_TOPIC),
    FRM_EVENTS(Constants.FRM_TOPIC);

    private final String topicName;

    KafkaTopic(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicName() {
        return topicName;
    }

    public static class Constants {
        public static final String CUSTOMER_VERIFICATION_SERVICE_TOPIC = "customer-verification-service-events";
        public static final String CUSTOMER_SERVICE_TOPIC = "customer-service-events";
        public static final String UPI_SERVICE_TOPIC = "upi-service-events";
        public static final String TRANSACTION_SERVICE_TOPIC = "transaction-service-events";
        public static final String NOTIFICATION_SERVICE_TOPIC = "notification-service-events";
        public static final String APP_SERVICE_TOPIC = "app-service-events";
        public static final String MAINTENANCE_SERVICE_TOPIC = "maintenance-service-events";
        public static final String INIT_SERVICE_TOPIC = "init-service-events";
        public static final String AUDIT_TOPIC = "audit-events";
        public static final String FRM_TOPIC = "frm-events";
    }
}


