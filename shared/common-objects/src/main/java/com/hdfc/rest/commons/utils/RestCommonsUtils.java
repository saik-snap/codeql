package com.hdfc.rest.commons.utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.security.SecureRandom;
import java.time.OffsetDateTime;
import java.util.Map;
import java.util.UUID;

public class RestCommonsUtils {

    private static final String SOURCE_HEADER_DATA_API = "";
    private static final String SOURCE_HEADER_OTP_API = "test";
    private static final String CHANNEL_HEADER_DATA_API = "MB";
    private static final String CHANNEL_HEADER_OTP_API = "mb";
    private static final String TRANSACTION_REFERENCE_NUMBER_HEADER = "MB-";
    public static final String TXN_ID_PREFIX = "MBT";
    public static final String NON_FINANCIAL_TXN_ID_PREFIX = "MBTNF";

    public static Map<String, String> generateHeadersForDataApi() {

        return Map.of("source", SOURCE_HEADER_DATA_API,
                "channel", CHANNEL_HEADER_DATA_API,
                "txn_ref_no", generateTransactionReferenceNumber(),
                "txn_dttm", getCurrentEpochMilliseconds(),
                "uuid", UUID.randomUUID().toString());
    }

    public static Map<String, String> generateHeadersForOtpApi(String ip) {
        return Map.of("source", SOURCE_HEADER_OTP_API,
                "channel", CHANNEL_HEADER_OTP_API,
                "ref-number", generateTransactionReferenceNumber(),
                "txn-datetime", getCurrentEpochMilliseconds(),
                "uuid", UUID.randomUUID().toString(),
                "ip", ip);
    }


    public static String generateTransactionReferenceNumber() {
        return TRANSACTION_REFERENCE_NUMBER_HEADER +
                System.currentTimeMillis() +
                (10 + new SecureRandom().nextInt(90));
    }

    public static String getCurrentEpochMilliseconds() {
        return String.valueOf(OffsetDateTime.now().toEpochSecond());
    }

    public static String genTxnId() {
        String uuid = UUID.randomUUID().toString();
        return TXN_ID_PREFIX + uuid.replaceAll("-", "");
    }

    public static long generateReferenceNumber() {
        return System.currentTimeMillis() +
                (10 + new SecureRandom().nextInt(90));

    }

    public static Map<String, String> generateHeadersWithIpForDataApi(String ip, String refNo) {
        return Map.of("source", SOURCE_HEADER_DATA_API,
                "channel", CHANNEL_HEADER_DATA_API,
                "ip", ip,
                "txn_ref_no", refNo,
                "txn_dttm", getCurrentEpochMilliseconds(),
                "uuid", UUID.randomUUID().toString());
    }

    public static Map<String, String> generateHeadersWithIpForDataApi(String ip) {
        return generateHeadersWithIpForDataApi(ip, generateTransactionReferenceNumber());
    }

    public static String getNonFinancialTxnId() {
        return NON_FINANCIAL_TXN_ID_PREFIX + RandomStringUtils.randomAlphanumeric(30);
    }
}
