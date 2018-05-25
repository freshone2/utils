package com.common.model.dto.promotion;

public class IntegralPublishDTO {
    private Integer strategyId;
    private String appCode;

    public Integer getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Integer strategyId) {
        this.strategyId = strategyId;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    @Override
    public String toString() {
        return "IntegralPublishDTO{" +
                "strategyId=" + strategyId +
                ", appCode='" + appCode + '\'' +
                '}';
    }
}
