package com.common.model.dto.pay;

public class OrderTransDTO {

    private String appCode;

    private String orderId;

    //交易类型 支付：01 退款：02
    private String transType;

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    @Override
    public String toString() {
        return "OrderTransDTO{" +
                "appCode='" + appCode + '\'' +
                ", orderId='" + orderId + '\'' +
                ", transType='" + transType + '\'' +
                '}';
    }
}
