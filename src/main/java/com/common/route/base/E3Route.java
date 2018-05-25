package com.common.route.base;

import com.common.model.dto.ResultDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Author hongql
 *
 * @Date Created by blm on 3/5/18.
 * @Description 描述
 */
public interface E3Route {
    /**
     * 获取渠道编码有效性
     *
     * @param channel 渠道编码
     * @return
     */
    @GetMapping(value = "/v1/e3/channel/code/validaty")
    ResultDTO checkChannelCodeValidity(@RequestParam("channel") String channel);

    /**
     * 获取商品编码有效性
     *
     * @param code 商品编码
     * @return
     */
    @GetMapping(value = "/v1/e3/code/validity")
    ResultDTO checkGoodsCodeValidity(@RequestParam("code")String code);

    /**
     * 获取商品库存
     *
     * @param code 商品编码
     * @param wareHouseCode 仓库编号
     * @return
     */
    @GetMapping(value = "/v1/e3/inventory")
     ResultDTO findCommodityInventory(@RequestParam("code") String code,@RequestParam("wareHouseCode") String wareHouseCode);

    /**
     * 商品库存同步(全量)
     *
     * @return
     */
    @GetMapping(value = "/v1/e3/inventory/all")
    ResultDTO syncInventory();

    /**
     * 创建E3订单
     *
     * @param body 商城大订单id
     * @return
     */
    @PostMapping(value = "/v1/e3/order")
    ResultDTO createE3Order(@RequestBody Map<String, String> body);

    /**
     * 查询订单发货状态
     *
     * @param orderId 商城大订单号
     * @return
     */
    @GetMapping(value = "/v1/e3/order/delivery")
    ResultDTO queryDelivery(@RequestParam("orderId") String orderId);

    /**
     * 取消订单发货
     *
     * @param orderId 商城大订单号
     * @return
     */
    @GetMapping(value = "/v1/e3/order/delivery/cancel")
    ResultDTO cancelDelivery(@RequestParam("orderId") String orderId);

    /**
     * 作废订单
     *
     * @param body 要作废的商城订单
     * @return
     */
    @PutMapping(value = "/v1/e3/invalid")
    public ResultDTO invalidOrder(@RequestBody Map<String, String> body) ;

    /**

    /**
     * 创建退款订单
     *
     * @param body 商城退款订单号
     * @return
     */
    @PostMapping(value = "/v1/e3/refund")
    ResultDTO createE3RefundOrder(@RequestBody Map<String, String> body);

    /**
     * 查询退单入库信息
     *
     * @param refundOrderId 商城退款订单号
     * @return
     */
    @GetMapping(value = "/v1/e3/refund/status")
    ResultDTO queryOrderReturnGoodsStatus(@RequestParam("refundOrderId") String refundOrderId);


}
