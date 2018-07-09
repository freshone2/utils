package com.common.model.bo.platform;

/**
 * @Package: pecker.model.bo.platform
 * @Description:
 * @author: jklofs
 * @date: 2018/5/14 下午1:53
 */
public class PlatformContentBo {

    /**
     * ID
     *
     */
    private Integer id;

    /**
     * 标题
     */
    private String title;

    /**
     * 平台活动有效开始时间
     */
    private Long effectiveStartAt;

    /**
     * 平台活动有效结束时间
     */
    private Long effectiveEndAt;

    /**
     * 优惠方式：金额满减 0， 金额满折 ：1 数量满减 2， 数量满折 ：3
     */
    private Integer preferentialType;

    /**
     * 门槛
     */
    private Double threshold;

    /**
     * 是否互斥 不互斥 0 ，互斥 1
     *
     */
    private Integer mutex;

    /**
     * 优惠金额，或折扣数
     */
    private Double value;

    /**
     * 最大优惠金额
     */
    private Double maxDiscount;

    /**
     * 渠道标识
     */
    private String appCode;

    /**
     * 发放限制： 不限制 -1
     */
    private Integer distributeLimit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getEffectiveStartAt() {
        return effectiveStartAt;
    }

    public void setEffectiveStartAt(Long effectiveStartAt) {
        this.effectiveStartAt = effectiveStartAt;
    }

    public Long getEffectiveEndAt() {
        return effectiveEndAt;
    }

    public void setEffectiveEndAt(Long effectiveEndAt) {
        this.effectiveEndAt = effectiveEndAt;
    }

    public Integer getPreferentialType() {
        return preferentialType;
    }

    public void setPreferentialType(Integer preferentialType) {
        this.preferentialType = preferentialType;
    }

    public Double getThreshold() {
        return threshold;
    }

    public void setThreshold(Double threshold) {
        this.threshold = threshold;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getMaxDiscount() {
        return maxDiscount;
    }

    public void setMaxDiscount(Double maxDiscount) {
        this.maxDiscount = maxDiscount;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public Integer getDistributeLimit() {
        return distributeLimit;
    }

    public void setDistributeLimit(Integer distributeLimit) {
        this.distributeLimit = distributeLimit;
    }

    public Integer getMutex() {
        return mutex;
    }

    public void setMutex(Integer mutex) {
        this.mutex = mutex;
    }

    @Override
    public String toString() {
        return "PlatformContentBo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", effectiveStartAt=" + effectiveStartAt +
                ", effectiveEndAt=" + effectiveEndAt +
                ", preferentialType=" + preferentialType +
                ", threshold=" + threshold +
                ", mutex=" + mutex +
                ", value=" + value +
                ", maxDiscount=" + maxDiscount +
                ", appCode='" + appCode + '\'' +
                ", distributeLimit=" + distributeLimit +
                '}';
    }
}
