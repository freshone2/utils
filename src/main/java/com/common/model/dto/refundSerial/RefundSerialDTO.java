package com.common.model.dto.refundSerial;

import java.util.List;

/**
 * @Package: pecker.model.dto
 * @Description:
 * @author: jklofs
 * @date: 2018/4/19 上午11:53
 */
public class RefundSerialDTO {
    private String userId;
    private String userPhone;
    private String appCode;
    private String channel;
    private String orderId;
    private String refundOrderId;
    private String paymentSerial;
    private String orderType;
    private String platformCode;
    private String reason;
    private String serialNum;
    private String status;
    private String payChannel;
    private Integer type;
    private String basePrice;
    private String realPrice;
    private String integral;
    private String orderPrice;
    private List<String> relatedSerials;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRefundOrderId() {
        return refundOrderId;
    }

    public void setRefundOrderId(String refundOrderId) {
        this.refundOrderId = refundOrderId;
    }

    public String getPaymentSerial() {
        return paymentSerial;
    }

    public void setPaymentSerial(String paymentSerial) {
        this.paymentSerial = paymentSerial;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getPlatformCode() {
        return platformCode;
    }

    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }

    public String getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(String realPrice) {
        this.realPrice = realPrice;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

    public List<String> getRelatedSerials() {
        return relatedSerials;
    }

    public void setRelatedSerials(List<String> relatedSerials) {
        this.relatedSerials = relatedSerials;
    }

    @Override
    public String toString() {
        return "RefundSerialDTO{" +
                "userId='" + userId + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", appCode='" + appCode + '\'' +
                ", channel='" + channel + '\'' +
                ", orderId='" + orderId + '\'' +
                ", refundOrderId='" + refundOrderId + '\'' +
                ", paymentSerial='" + paymentSerial + '\'' +
                ", orderType='" + orderType + '\'' +
                ", platformCode='" + platformCode + '\'' +
                ", reason='" + reason + '\'' +
                ", serialNum='" + serialNum + '\'' +
                ", status='" + status + '\'' +
                ", payChannel='" + payChannel + '\'' +
                ", type=" + type +
                ", basePrice='" + basePrice + '\'' +
                ", realPrice='" + realPrice + '\'' +
                ", integral='" + integral + '\'' +
                ", orderPrice='" + orderPrice + '\'' +
                ", relatedSerials=" + relatedSerials +
                '}';
    }
}
