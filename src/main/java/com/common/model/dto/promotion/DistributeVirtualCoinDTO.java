package com.common.model.dto.promotion;

/**
 * @Package: pecker.model.dto
 * @Description:
 * @author: jklofs
 * @date: 2018/5/19 下午2:46
 */
public class DistributeVirtualCoinDTO {
    private String userId;

    private String appCode;

    private Long timeout;

    private Double virtualCoin;

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

    public Long getTimeout() {
        return timeout;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    public Double getVirtualCoin() {
        return virtualCoin;
    }

    public void setVirtualCoin(Double virtualCoin) {
        this.virtualCoin = virtualCoin;
    }

    @Override
    public String toString() {
        return "DistributeVirtualCoinDTO{" +
                "userId='" + userId + '\'' +
                ", appCode='" + appCode + '\'' +
                ", timeout=" + timeout +
                ", virtualCoin=" + virtualCoin +
                '}';
    }
}
