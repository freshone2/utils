package com.common.model.dto.order;

import java.util.List;

/**
 * @Package: pecker.model.dto
 * @Description:
 * @author: jklofs
 * @date: 2018/4/2 下午4:22
 */
public class PayOrderSuccessDTO {
    private List<String> orderIds;
    private String payChannel;
    private String serialNum;
    private String price;
    private Integer orderType;

    public List<String> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<String> orderIds) {
        this.orderIds = orderIds;
    }

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    @Override
    public String toString() {
        return "PaySerialSuccessDTO{" +
                "orderIds=" + orderIds +
                ", payChannel='" + payChannel + '\'' +
                ", serialNum='" + serialNum + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
