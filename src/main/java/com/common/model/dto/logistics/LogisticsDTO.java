package com.common.model.dto.logistics;

import java.util.List;

/**
 * @Package: pecker.model.dto
 * @Description:
 * @author: jklofs
 * @date: 2018/4/26 上午10:02
 */
public class LogisticsDTO {
    private String logisticsId;
    private String logisticsCode;
    private List<String> orderIds;
    private Integer type;

    public String getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String getLogisticsCode() {
        return logisticsCode;
    }

    public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode;
    }

    public List<String> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<String> orderIds) {
        this.orderIds = orderIds;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "LogisticsDTO{" +
                "logisticsId='" + logisticsId + '\'' +
                ", logisticsCode='" + logisticsCode + '\'' +
                ", orderIds=" + orderIds +
                ", type=" + type +
                '}';
    }
}
