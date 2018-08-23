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
    private String jgjCouponId;
    private Integer jgjUsableCouponsNum;
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

    public String getJgjCouponId() {
        return jgjCouponId;
    }

    public void setJgjCouponId(String jgjCouponId) {
        this.jgjCouponId = jgjCouponId;
    }

    public Integer getJgjUsableCouponsNum() {
        return jgjUsableCouponsNum;
    }

    public void setJgjUsableCouponsNum(Integer jgjUsableCouponsNum) {
        this.jgjUsableCouponsNum = jgjUsableCouponsNum;
    }

    @Override
    public String toString() {
        return "UserCouponBo{" +
                "couponId=" + couponId +
                ", activityCouponId=" + activityCouponId +
                ", jgjCouponId='" + jgjCouponId + '\'' +
                ", jgjUsableCouponsNum=" + jgjUsableCouponsNum +
                ", couponContentBo=" + couponContentBo +
                '}';
    }
}
