package com.common.model.dto.pay;

/**
 * @Package: pecker.model.dto
 * @Description:
 * @author: jklofs
 * @date: 2018/4/17 下午2:15
 */
public class PaySerialSuccessDTO {
    private String serialNum;
    private String id;
    private String payChannel;
    private String appCode;

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    @Override
    public String toString() {
        return "PaySerialSuccessDTO{" +
                "serialNum='" + serialNum + '\'' +
                ", id='" + id + '\'' +
                ", payChannel='" + payChannel + '\'' +
                ", appCode='" + appCode + '\'' +
                '}';
    }
}
