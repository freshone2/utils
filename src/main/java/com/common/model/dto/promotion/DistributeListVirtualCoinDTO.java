package com.common.model.dto.promotion;

import java.util.List;

/**
 * @Package: pecker.model.dto
 * @Description:
 * @author: jklofs
 * @date: 2018/5/19 下午2:49
 */
public class DistributeListVirtualCoinDTO {
    private List<String> userIds;

    private String appCode;

    private Long timeout;

    private Double virtualCoin;

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userId) {
        this.userIds = userId;
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
        return "DistributeListVirtualCoinDTO{" +
                "userIds=" + userIds +
                ", appCode='" + appCode + '\'' +
                ", timeout=" + timeout +
                ", virtualCoin=" + virtualCoin +
                '}';
    }
}
