package com.common.model.bo.virtualcoin;

/**
 * @Package: com.common.model.bo.virtualcoin
 * @Description:
 * @author: jklofs
 * @date: 2018/5/19 上午10:38
 */
public class TimeSharingItem {
    /**
     * 积分具体分时积分数额
     *
     */
    private Double virtualCoin;

    /**
     * 分时标识
     *
     */
    private Long timeout;

    public Double getVirtualCoin() {
        return virtualCoin;
    }

    public void setVirtualCoin(Double virtualCoin) {
        this.virtualCoin = virtualCoin;
    }

    public Long getTimeout() {
        return timeout;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    @Override
    public String toString() {
        return "TimeSharingItem{" +
                "virtualCoin=" + virtualCoin +
                ", timeout=" + timeout +
                '}';
    }
}
