package com.common.model.bo.coupon;

/**
 * @Package: pecker.model.bo.promotion
 * @Description:
 * @author: jklofs
 * @date: 2018/5/15 下午1:53
 */
public class UserCouponBo {
    private Integer couponId;
    private Integer activityCouponId;
    private ActivityCouponContentBo couponContentBo;

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Integer getActivityCouponId() {
        return activityCouponId;
    }

    public void setActivityCouponId(Integer activityCouponId) {
        this.activityCouponId = activityCouponId;
    }

    public ActivityCouponContentBo getCouponContentBo() {
        return couponContentBo;
    }

    public void setCouponContentBo(ActivityCouponContentBo couponContentBo) {
        this.couponContentBo = couponContentBo;
    }
}
