package com.common.route.base;

import com.common.model.dto.ResultDTO;
import com.common.model.dto.jgj.coupon.*;
import com.common.model.dto.jgj.product.ProductInfoRequestDTO;
import com.peacock.feather.support.ResponseWrapper;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/jgj")
public interface JgjRoute {

    @GetMapping("/v1/order")
    ResultDTO syncOrderToJgj(@RequestHeader("requestId")String requestId, @RequestParam("orderId") String orderId);

    @PostMapping("/v1/coupon/queryUsableCoupons")
    ResultDTO<QueryUsableCouponsResponseDTO> queryUsableCoupons(
            @RequestHeader(value = "requestId")String requestId,
            @RequestBody UsableCouponRequestDTO usableCouponRequestDTO);

    @PostMapping("/v1/coupon/lockCoupon")
    ResultDTO<?> lockCoupon(
            @RequestHeader(value = "requestId")String requestId,
            @RequestBody LockCouponRequestDTO lockCouponRequestDTO);

    @PostMapping("/v1/coupon/checkCoupon")
    ResultDTO<?> checkCoupon(
            @RequestHeader(value = "requestId")String requestId,
            @RequestBody CheckCouponRequestDTO checkCouponRequestDTO);

    @PostMapping("/v1/coupon/haveAvailableCoupons")
    ResultDTO<HaveAvailableCouponsResponseDTO> haveAvailableCoupons(
            @RequestHeader(value = "requestId")String requestId,
            @RequestBody HaveAvailableCouponsRequestDTO haveAvailableCouponsRequestDTO);

    @PostMapping("/v1/coupon/updateCouponsStatusForESG")
    ResultDTO<?> updateCouponsStatusForESG(
            @RequestHeader(value = "requestId")String requestId,
            @RequestBody UpdateCouponsStatusRequestDTO updateCouponsStatusRequestDTO);

    @PostMapping("/v1/coupon/distributeCouponsForEsg")
    ResultDTO<DistributeCouponsResponseDTO> DistributeCouponsForEsg(
            @RequestHeader(value = "requestId")String requestId,
            @RequestBody DistributeCouponsRequestDTO distributeCouponsRequestDTO);

    @PostMapping("/v1/product/receiveLifeProductInfo")
    ResultDTO<?> receiveLifeProductInfo(
            @RequestHeader(value = "requestId")String requestId,
            @RequestBody ProductInfoRequestDTO productInfoRequestDTO);

    @PostMapping("/v1/common/accessToken")
    ResultDTO<String> getAccessToken(
            @RequestHeader(value = "requestId")String requestId);
}
