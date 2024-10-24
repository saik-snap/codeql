package com.hdfc.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public final class CommonServiceUtils {

    private CommonServiceUtils() {
    }

    public static String getIpAddress(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress != null
                && !ipAddress.isBlank()
                && ipAddress.split(",").length > 0) {
            String[] ips = ipAddress.split(",");
            return ips[0].trim();
        }
        return Optional.ofNullable(ipAddress)
                .filter(ip -> !ip.isBlank())
                .orElse(request.getRemoteAddr());
    }

    public static String cleanUserId(String userId) {
        return userId.contains("@")
                ? userId.substring(0, userId.indexOf("@"))
                : userId;
    }
}
