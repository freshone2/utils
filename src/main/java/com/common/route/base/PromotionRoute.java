package com.common.route.base;

import com.common.model.bo.commodity.CommodityBo;
import com.common.model.bo.order.OrderBo;
import com.common.model.dto.ResultDTO;
import com.common.model.dto.order.CalculatingDTO;
import com.common.model.dto.promotion.DistributeListVirtualCoinDTO;
import com.common.model.dto.promotion.DistributeVirtualCoinDTO;
import com.common.model.dto.promotion.RestorationCoinDTO;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

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
     ResultDTO<CalculatingDTO> calculationOrderActivity(@RequestHeader("requestId") String requestId,@RequestBody OrderBo orderBo);

    /**
     * 计算订单金额（并使用）
     *
     * @param orderBo
     * @return
     */
    @PostMapping("/activity/calculation/used")
     ResultDTO<CalculatingDTO> calculationOrderAndUse(@RequestHeader("requestId") String requestId,@RequestBody OrderBo orderBo);

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
     ResultDTO restorationCoupon(@RequestHeader("requestId") String requestId,@RequestParam("userId") String userId, @RequestParam("userId") String appCode
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
    ResultDTO giveCoupon(@RequestHeader("requestId") String requestId,@RequestParam("userId") String userId
            ,@RequestParam("appCode") String appCode ,@RequestParam("activityCouponId")  Integer activityCouponId);

    /**
     * 单个分发积分
     *
     * @param coinDTO
     * @return
     */
    @PostMapping("/user/virtualCoin")
    ResultDTO giveVirtualCoin(@RequestHeader("requestId") String requestId,@RequestBody DistributeVirtualCoinDTO coinDTO);

    /**
     * 批量分发积分
     *
     * @param coinDTO
     * @return
     */
    @PostMapping("/batch/virtualCoin")
    ResultDTO giveVirtualCoinList(@RequestHeader("requestId") String requestId,@RequestBody DistributeListVirtualCoinDTO coinDTO);

    /**
     * 返还积分
     *
     * @param coinDTO
     * @return
     */
    @PostMapping("/user/virtualCoin/restoration")
    ResultDTO restorationCoin(@RequestHeader("requestId") String requestId,@RequestBody RestorationCoinDTO coinDTO);

    /**
     * 检索用户积分并过期
     *
     * @param userId
     * @param appCode
     * @return
     */
    @PostMapping("/user/virtualCoin/expire")
    ResultDTO expireVirtualCoin(@RequestHeader("requestId") String requestId,@RequestParam("userId") String userId, @RequestParam("userId") String appCode );

    @PostMapping("/commodity/special")
    ResultDTO<List<CommodityBo>> createdSpecialActivityWithCommodities(@RequestHeader("requestId") String requestId,@RequestHeader("userId") String userId
            , @RequestHeader("appCode") String appCode, @RequestBody List<CommodityBo> commodities);

}
