package com.common.model.dto.jgj.coupon;

import lombok.Data;

import java.util.List;

/**
 * Created by wangwei on 2018/8/15.
 */
@Data
public class QueryUsableCouponsResponseDTO {

    @Data
    public static class DiscountCouponDTO{

        //优惠金额
        private Double discountMoney;

        //最优惠优惠券ID
        private String couponId;

    }

    //最优惠优惠券是否有叠加券
    private String isNotSuperpose;

    //是否需要更新版本才可用
    private String isNotUpdate;

    //可用优惠券数量
    private Integer usableCouponsNum;

    //最优惠优惠金额
    private Double bestDiscountAmount;

    private List<DiscountCouponDTO> bestDiscountCouponList;

}
