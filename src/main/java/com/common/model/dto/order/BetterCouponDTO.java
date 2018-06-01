package com.common.model.dto.order;


import com.common.model.bo.coupon.UserCouponBo;

import java.util.List;

/**
 * @Package: pecker.model.vo
 * @Description:
 * @author: jklofs
 * @date: 2018/5/24 下午3:39
 */
public class BetterCouponDTO {
    private UserCouponBo betterCoupon;

    private List<UserCouponBo> canUsedCoupons;

    private List<UserCouponBo> unUsedCoupons;

    public UserCouponBo getBetterCoupon() {
        return betterCoupon;
    }

    public void setBetterCoupon(UserCouponBo betterCoupon) {
        this.betterCoupon = betterCoupon;
    }

    public List<UserCouponBo> getCanUsedCoupons() {
        return canUsedCoupons;
    }

    public void setCanUsedCoupons(List<UserCouponBo> canUsedCoupons) {
        this.canUsedCoupons = canUsedCoupons;
    }

    public List<UserCouponBo> getUnUsedCoupons() {
        return unUsedCoupons;
    }

    public void setUnUsedCoupons(List<UserCouponBo> unUsedCoupons) {
        this.unUsedCoupons = unUsedCoupons;
    }

    @Override
    public String toString() {
        return "BetterCouponDTO{" +
                "betterCoupon=" + betterCoupon +
                ", canUsedCoupons=" + canUsedCoupons +
                ", unUsedCoupons=" + unUsedCoupons +
                '}';
    }
}
