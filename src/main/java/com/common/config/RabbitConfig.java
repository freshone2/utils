package com.common.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "rabbit")
public class RabbitConfig {
    private String orderExchange = "mall_order_exchange";
    private String orderRoutingKey = "mall_order_routing";
    private String refundExchange = "mall_refund_exchange";
    private String refundRoutingKey = "mall_refund_routing";
    private String payExchange = "mall_pay_exchange";
    private String payRoutingKey = "mall_pay_routing";
    private String activityExchange = "mall_activity_exchange";
    private String activityRoutingKey = "mall_activity_routing";
    private String crmExchange = "mall_crm_exchange";
    private String crmRoutingKey = "mall_crm_routing";

    public String getCrmExchange() {
        return crmExchange;
    }

    public void setCrmExchange(String crmExchange) {
        this.crmExchange = crmExchange;
    }

    public String getCrmRoutingKey() {
        return crmRoutingKey;
    }

    public void setCrmRoutingKey(String crmRoutingKey) {
        this.crmRoutingKey = crmRoutingKey;
    }

    public String getOrderExchange() {
        return orderExchange;
    }

    public void setOrderExchange(String orderExchange) {
        this.orderExchange = orderExchange;
    }

    public String getOrderRoutingKey() {
        return orderRoutingKey;
    }

    public void setOrderRoutingKey(String orderRoutingKey) {
        this.orderRoutingKey = orderRoutingKey;
    }

    public String getRefundExchange() {
        return refundExchange;
    }

    public void setRefundExchange(String refundExchange) {
        this.refundExchange = refundExchange;
    }

    public String getRefundRoutingKey() {
        return refundRoutingKey;
    }

    public void setRefundRoutingKey(String refundRoutingKey) {
        this.refundRoutingKey = refundRoutingKey;
    }

    public String getPayExchange() {
        return payExchange;
    }

    public void setPayExchange(String payExchange) {
        this.payExchange = payExchange;
    }

    public String getPayRoutingKey() {
        return payRoutingKey;
    }

    public void setPayRoutingKey(String payRoutingKey) {
        this.payRoutingKey = payRoutingKey;
    }

    public String getActivityExchange() {
        return activityExchange;
    }

    public void setActivityExchange(String activityExchange) {
        this.activityExchange = activityExchange;
    }

    public String getActivityRoutingKey() {
        return activityRoutingKey;
    }

    public void setActivityRoutingKey(String activityRoutingKey) {
        this.activityRoutingKey = activityRoutingKey;
    }
}
