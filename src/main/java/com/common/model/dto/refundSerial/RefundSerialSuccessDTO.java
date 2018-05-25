package com.common.model.dto.refundSerial;

/**
 * @Package: pecker.model.dto
 * @Description:
 * @author: jklofs
 * @date: 2018/4/19 下午1:49
 */
public class RefundSerialSuccessDTO {
    private String serialNum;
    private String appCode;

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    @Override
    public String toString() {
        return "RefundSerialSuccessDTO{" +
                "serialNum='" + serialNum + '\'' +
                ", appCode='" + appCode + '\'' +
                '}';
    }
}
