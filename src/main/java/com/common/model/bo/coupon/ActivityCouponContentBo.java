package com.common.model.bo.coupon;

/**
 * @Package: pecker.model.bo.coupon
 * @Description:
 * @author: jklofs
 * @date: 2018/5/14 上午11:06
 */
public class ActivityCouponContentBo {
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
     * 发放开始时间
     */
    private Long distributeStartAt;

    /**
     * 发放结束时间
     */
    private Long distributeEndAt;

    /**
     * 优惠券有效开始时间
     */
    private Long effectiveStartAt;

    /**
     * 优惠券有效结束时间
     */
    private Long effectiveEndAt;

    /**
     * 有效时间 ：0 ，有效日期：1
     */
    private Integer termType;

    /**
     * 有效时间
     */
    private Integer effectiveDay;

    /**
     * 优惠方式：满减 0， 满折 ：1
     */
    private Integer preferentialType;

    /**
     * 门槛
     */
    private Double threshold;

    /**
     * 优惠金额，或折扣数
     */
    private Double value;

    /**
     * 最大优惠金额
     */
    private Double maxDiscount;

    /**
     * 优惠券类型：全场 0
     */
    private Integer couponType;

    /**
     * 发放类型：直接投放 0 ，用户领取 1
     */
    private Integer distributeType;

    /**
     * 渠道标识
     */
    private String appCode;

    /**
     * 发放范围 ： 全部发放 0 ，名单发放 1
     */
    private Integer distributeRange;

    /**
     * 发放限制： 不限制 -1
     */
    private Integer distributeLimit;

    /**
     * 是否互斥 不互斥 0 ，互斥 1
     *
     */
    private Integer mutex;

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

    public Long getDistributeStartAt() {
        return distributeStartAt;
    }

    public void setDistributeStartAt(Long distributeStartAt) {
        this.distributeStartAt = distributeStartAt;
    }

    public Long getDistributeEndAt() {
        return distributeEndAt;
    }

    public void setDistributeEndAt(Long distributeEndAt) {
        this.distributeEndAt = distributeEndAt;
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

    public Integer getTermType() {
        return termType;
    }

    public void setTermType(Integer termType) {
        this.termType = termType;
    }

    public Integer getEffectiveDay() {
        return effectiveDay;
    }

    public void setEffectiveDay(Integer effectiveDay) {
        this.effectiveDay = effectiveDay;
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

    public Integer getCouponType() {
        return couponType;
    }

    public void setCouponType(Integer couponType) {
        this.couponType = couponType;
    }

    public Integer getDistributeType() {
        return distributeType;
    }

    public void setDistributeType(Integer distributeType) {
        this.distributeType = distributeType;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public Integer getDistributeRange() {
        return distributeRange;
    }

    public void setDistributeRange(Integer distributeRange) {
        this.distributeRange = distributeRange;
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
        return "ActivityCouponContentBo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", distributeStartAt=" + distributeStartAt +
                ", distributeEndAt=" + distributeEndAt +
                ", effectiveStartAt=" + effectiveStartAt +
                ", effectiveEndAt=" + effectiveEndAt +
                ", termType=" + termType +
                ", effectiveDay=" + effectiveDay +
                ", preferentialType=" + preferentialType +
                ", threshold=" + threshold +
                ", value=" + value +
                ", maxDiscount=" + maxDiscount +
                ", couponType=" + couponType +
                ", distributeType=" + distributeType +
                ", appCode='" + appCode + '\'' +
                ", distributeRange=" + distributeRange +
                ", distributeLimit=" + distributeLimit +
                ", mutex=" + mutex +
                '}';
    }
}
