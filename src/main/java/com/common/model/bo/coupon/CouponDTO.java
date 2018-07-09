package com.common.model.bo.coupon;

public class CouponDTO {

    private Integer couponId;

    private Integer activityCouponContentId;

    private String userId;

    private Long distributeTime;

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Integer getActivityCouponContentId() {
        return activityCouponContentId;
    }

    public void setActivityCouponContentId(Integer activityCouponContentId) {
        this.activityCouponContentId = activityCouponContentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getDistributeTime() {
        return distributeTime;
    }

    public void setDistributeTime(Long distributeTime) {
        this.distributeTime = distributeTime;
    }

    @Override
    public String toString() {
        return "CouponDTO{" +
                "couponId=" + couponId +
                ", activityCouponContentId=" + activityCouponContentId +
                ", userId='" + userId + '\'' +
                ", distributeTime=" + distributeTime +
                '}';
    }
}
