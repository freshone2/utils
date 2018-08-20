package com.common.model.dto.jgj.coupon;

import lombok.Data;

/**
 * Created by wangwei on 2018/8/15.
 */
@Data
public class DistributeCouponsResponseDTO {

    //下发渠道
    private String channelType;

    //优惠券状态 00已领取/01已使用/02正在使用
    private String couponStatus;

    //过期时间
    private Long endDate;

    //代金券类型 AA代金券/AB折扣券
    private String couponType;

    //优惠金额 AA为代金券1元 AB为1折
    private String discountAmount;

    //优惠券ID
    private String couponId;

    //折扣上限
    private String restrictAmount;

    //领取用户
    private String mobilePhone;

    //优惠券批次ID
    private String couponBatchId;

    //奖品唯一ID
    private String prizeId;

    //优惠券名称
    private String couponName;

    //使用范围
    private String couponArea;

    //指定商品编码
    private String merchandiseCode;

    //内容描述
    private String contentDescribe;

    //使用描述
    private String useCondition;

    //详情描述
    private String detailDescribe;

    //跳转类型
    private String jumpType;

    //跳转地址
    private String jumpUrl;

    //开始时间
    private Long startDate;

    //使用时间
    private Long userDate;
}
