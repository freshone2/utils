package com.common.model.dto.pay;

import java.util.List;

/**
 * @Package: pecker.model.dto
 * @Description:
 * @author: jklofs
 * @date: 2018/4/16 下午4:01
 */
public class PaySerialDTO {
    private String serialNum;
    private String orderId;
    private String channel;
    private Double orderPrice;
    private Double realPrice;
    private Double basePrice;
    private Double integral;
    private String userId;
    private String appCode;
    private String payChannel;
    private Integer type;
    private String status;
    private String platformCode;
    private Integer orderType;
    private List<String> relatedSerials;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Double getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Double realPrice) {
        this.realPrice = realPrice;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Double getIntegral() {
        return integral;
    }

    public void setIntegral(Double integral) {
        this.integral = integral;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getPlatformCode() {
        return platformCode;
    }

    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
    }

    public List<String> getRelatedSerials() {
        return relatedSerials;
    }

    public void setRelatedSerials(List<String> relatedSerials) {
        this.relatedSerials = relatedSerials;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "PaySerialDTO{" +
                "serialNum='" + serialNum + '\'' +
                ", orderId='" + orderId + '\'' +
                ", channel='" + channel + '\'' +
                ", orderPrice=" + orderPrice +
                ", realPrice=" + realPrice +
                ", basePrice=" + basePrice +
                ", integral=" + integral +
                ", userId='" + userId + '\'' +
                ", appCode='" + appCode + '\'' +
                ", payChannel='" + payChannel + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", platformCode='" + platformCode + '\'' +
                ", relatedSerials=" + relatedSerials +
                '}';
    }
}
