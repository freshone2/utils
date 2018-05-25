package com.common.route.base;

import com.common.model.bo.order.OrderBo;
import com.common.model.dto.ResultDTO;
import com.common.model.dto.promotion.DistributeListVirtualCoinDTO;
import com.common.model.dto.promotion.DistributeVirtualCoinDTO;
import com.common.model.dto.promotion.RestorationCoinDTO;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * @Package: pecker.rest
 * @Description:
 * @author: jklofs
 * @date: 2018/5/17 下午4:58
 */
@RequestMapping("/v1")
public interface PromotionRoute {

    /**
     * 计算订单金额
     *
     * @param orderBo
     * @return
     */
    @PostMapping("/activity/calculation/unused")
     ResultDTO<OrderBo> calculationOrderActivity(@RequestBody OrderBo orderBo);

    /**
     * 计算订单金额（并使用）
     *
     * @param orderBo
     * @return
     */
    @PostMapping("/activity/calculation/used")
     ResultDTO<OrderBo> calculationOrderAndUse(@RequestBody OrderBo orderBo);

    /**
     * 退返优惠券
     *
     * @param userId
     * @param appCode
     * @param activityCouponId
     * @param couponId
     * @return
     */
    @PostMapping("/coupon/restoration")
     ResultDTO restorationCoupon(@RequestParam("userId") String userId, @RequestParam("userId") String appCode
            , @RequestParam(value = "activityCouponId") Integer activityCouponId
            , @RequestParam(value = "couponId") Integer couponId);

    /**
     * 获取优惠券
     *
     * @param userId
     * @param appCode
     * @param activityCouponId
     * @return
     */
    @PostMapping("/user/coupon")
    ResultDTO giveCoupon(@RequestParam("userId") String userId
            ,@RequestParam("appCode") String appCode ,@RequestParam("activityCouponId")  Integer activityCouponId);

    /**
     * 单个分发积分
     *
     * @param coinDTO
     * @return
     */
    @PostMapping("/user/virtualCoin")
    ResultDTO giveVirtualCoin(@RequestBody DistributeVirtualCoinDTO coinDTO);

    /**
     * 批量分发积分
     *
     * @param coinDTO
     * @return
     */
    @PostMapping("/batch/virtualCoin")
    ResultDTO giveVirtualCoinList(@RequestBody DistributeListVirtualCoinDTO coinDTO);

    /**
     * 返还积分
     *
     * @param coinDTO
     * @return
     */
    @PostMapping("/user/virtualCoin/restoration")
    ResultDTO restorationCoin(@RequestBody RestorationCoinDTO coinDTO);

    /**
     * 检索用户积分并过期
     *
     * @param userId
     * @param appCode
     * @return
     */
    @PostMapping("/user/virtualCoin/expire")
    ResultDTO expireVirtualCoin(@RequestParam("userId") String userId, @RequestParam("userId") String appCode );
}
