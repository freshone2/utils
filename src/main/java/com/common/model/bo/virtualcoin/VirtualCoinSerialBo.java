package com.common.model.bo.virtualcoin;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * @Package: com.common.model.bo.virtualcoin
 * @Description:
 * @author: jklofs
 * @date: 2018/5/19 上午10:36
 */
public class VirtualCoinSerialBo {

    @Id
    private String _id;

    /**
     * 用户标识
     */
    private String userId;

    /**
     * 关联的交易订单
     */
    private String orderId;

    /**
     * 使用的积分
     */
    private Double virtualCoin;

    /**
     * 流水参数时间
     *
     */
    private Long createdAt;

    /**
     * 交易类型,>0正向交易，<0负向交易
     *
     *  1 发放 2 退还
     *  -1 消费 -2 过期
     */
    private Integer type;

    /**
     * 应用编码
     */
    private String appCode;

    /**
     * 分时具体交易金额
     */
    private List<TimeSharingItem> timeSharing;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Double getVirtualCoin() {
        return virtualCoin;
    }

    public void setVirtualCoin(Double virtualCoin) {
        this.virtualCoin = virtualCoin;
    }

    public List<TimeSharingItem> getTimeSharing() {
        return timeSharing;
    }

    public void setTimeSharing(List<TimeSharingItem> timeSharing) {
        this.timeSharing = timeSharing;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

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

    @Override
    public String toString() {
        return "VirtualCoinSerialBo{" +
                "_id='" + _id + '\'' +
                ", userId='" + userId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", virtualCoin=" + virtualCoin +
                ", createdAt=" + createdAt +
                ", type=" + type +
                ", timeSharing=" + timeSharing +
                '}';
    }
}
