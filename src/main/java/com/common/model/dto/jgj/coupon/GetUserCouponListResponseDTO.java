package com.common.model.dto.jgj.coupon;

import lombok.Data;

import java.util.List;

/**
 * Created by wangwei on 2018/8/27.
 */
@Data
public class GetUserCouponListResponseDTO {

    @Data
    public static class SubCouponDTO{

        //能否转赠 "Y"/"N"
        private String transferable;

        //批次ID
        private String couponBatchId;

        //优惠券ID
        private String couponId;

        //优惠券名称
        private String couponName;

        //优惠券使用范围
        private String couponArea;

        //指定商品码
        private String merchandiseCode;

        //类型（AA/代金券  AB/折扣券 AC/满减 ）
        private String couponType;

        //内容描述  (上海家化)
        private String contentDescribe;

        //使用描述 （满9元可用）
        private String useCondition;

        //详情描述
        private String detailDescribe;

        //优惠金额/折扣/满减 （10）
        private String discountAmount;

        //跳转类型
        private String jumpType;

        //跳转URL
        private String jumpUrl;

        //生效时间
        private String startDate;

        //失效时间
        private String endDate;

        //二级目录
        private String couponSecondaryType;

        //单位
        private String couponUnit;

        //单位数量
        private String couponUnitNum;
    }

    //是否代理人 "Y"/"N"
    private String isAgent;

    private String isNotUpdate;

    //当前页
    private String page;

    //是否有下一页
    private String hasNextPage;

    //优惠券中心地址
    private String couponCenterUrl;

    private Integer notHaveUsedNum;

    private Integer expiredNum;

    private List<SubCouponDTO> subList;

}
