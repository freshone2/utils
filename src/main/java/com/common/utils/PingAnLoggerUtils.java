package com.common.utils;

import org.slf4j.MDC;

/**
 * @Package: pecker.config.logger
 * @Description:
 * @author: jklofs
 * @date: 2018/6/3 下午7:59
 */
public class PingAnLoggerUtils {

    public static final String REQUEST_ID = "REQUEST_ID";

    public static final String LOGGER_ID = "LOGGER_ID";

    public static final String INTERFACE_ID = "INTERFACE_ID";

    public static final String INTERFACE_NAME = "INTERFACE_NAME";

    public static final String INTERFACE_TYPE = "INTERFACE_TYPE";

    public static final String APP_CODE = "APP_CODE";

    public static final String FROM = "FROM";

    public static final String TO = "TO";

    public static final String REQUEST_STATUS = "REQUEST_STATUS";

    public static final String RESPONSE_CODE = "RESPONSE_CODE";

    public static final String REQUEST_CONTENT = "REQUEST_CONTENT";

    public static final String RESPONSE_CONTENT = "RESPONSE_CONTENT";

    public static final String START_AT = "START_AT";

    public static final String END_AT = "END_AT";

    public static final String SERVER_IP = "SERVER_IP";

    public static void setRequestId(String requestId) {
        MDC.put(REQUEST_ID,requestId);
    }

    public static void setLoggerId(String loggerId) {
        MDC.put( LOGGER_ID,loggerId);
    }

    public static void setInterfaceId(String interfaceId) {
        MDC.put( INTERFACE_ID,interfaceId);
    }

    public static void setInterfaceName(String interfaceName) {
        MDC.put( INTERFACE_NAME,interfaceName);
    }

    public static void setInterfaceType(String interfaceType) {
        MDC.put( INTERFACE_TYPE,interfaceType);
    }

    public static void setAppCode(String appCode) {
        MDC.put( APP_CODE,appCode);
    }

    public static void setFROM(String from) {
        MDC.put( FROM,from);
    }

    public static void setTO(String to) {
        MDC.put( TO,to);
    }

    public static void setRequestStatus(String requestStatus) {
        MDC.put( REQUEST_STATUS,requestStatus);
    }

    public static void setResponseCode(String responseCode) {
        MDC.put( RESPONSE_CODE,responseCode);
    }

    public static void setRequestContent(String requestContent) {
        MDC.put( REQUEST_CONTENT,requestContent);
    }

    public static void setResponseContent(String responseContent) {
        MDC.put( RESPONSE_CONTENT,responseContent);
    }

    public static void setStartAt(String startAt) {
        MDC.put( START_AT,startAt);
    }

    public static void setEndAt(String endAt) {
        MDC.put( END_AT,endAt);
    }

    public static void setServerIp(String serverIp) {
        MDC.put( SERVER_IP,serverIp);
    }


    public static String getRequestId() {
        return MDC.get(REQUEST_ID);
    }

    public static String getLoggerId() {
        return MDC.get(LOGGER_ID);
    }

    public static String getInterfaceId() {
        return MDC.get(INTERFACE_ID);
    }

    public static String getInterfaceName() {
        return MDC.get(INTERFACE_NAME);
    }

    public static String getInterfaceType() {
        return MDC.get(INTERFACE_TYPE);
    }

    public static String getAppCode() {
        return MDC.get(APP_CODE);
    }

    public static String getFROM() {
        return MDC.get(FROM);
    }

    public static String getTO() {
        return MDC.get(TO);
    }

    public static String getRequestStatus() {
        return MDC.get(REQUEST_STATUS);
    }

    public static String getResponseCode() {
        return MDC.get(RESPONSE_CODE);
    }

    public static String getRequestContent() {
        return MDC.get(REQUEST_CONTENT);
    }

    public static String getResponseContent() {
        return MDC.get(RESPONSE_CONTENT);
    }

    public static String getStartAt() {
        return MDC.get(START_AT);
    }

    public static String getEndAt() {
        return MDC.get(END_AT);
    }

    public static String getServerIp() {
        return MDC.get(SERVER_IP);
    }
}
