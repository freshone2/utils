package com.common.model.dto.pay;

/**
 * Created by wangwei on 2018/5/24.
 */
public class JahwaRefundDTO {

    private String appCode;

    private Double refundAmount;

    private String refundSerialNum;

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundSerialNum() {
        return refundSerialNum;
    }

    public void setRefundSerialNum(String refundSerialNum) {
        this.refundSerialNum = refundSerialNum;
    }

    @Override
    public String toString() {
        return "JahwaRefundDTO{" +
                "appCode='" + appCode + '\'' +
                ", refundAmount=" + refundAmount +
                ", refundSerialNum='" + refundSerialNum + '\'' +
                '}';
    }
}
