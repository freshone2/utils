package com.common.route.base;

import com.common.model.dto.ResultDTO;
import com.common.model.dto.order.*;
import org.springframework.web.bind.annotation.*;

/**
 * @Package: pecker.rest
 * @Description:
 * @author: jklofs
 * @date: 2018/4/13 下午7:00
 */
@RequestMapping("/v1/order")
public interface OrderRoute {

    /**
     * 创建订单
     *
     * @param orderDTO
     * @return
     */
    @PostMapping(value = "")
    ResultDTO createdOrder(@RequestBody OrderDTO orderDTO);

    /**
     * 更新订单
     *
     * @param orderDTO
     * @return
     */
    @PutMapping(value = "")
    ResultDTO updateOrder(@RequestBody OrderUpdateDTO orderDTO);


    /**
     * 更新订单状态（并绑定其他联动操作）
     *
     * @param requestDTO
     * @return
     */
    @PostMapping(value = "/status")
    ResultDTO updateStatus(@RequestBody StatusRequestDTO requestDTO);

    /**
     * 更新订单状态（无其他联动操作）
     *
     * @param requestDTO
     * @return
     */
    @PostMapping(value = "/status/only")
    ResultDTO updateStatusOnly(@RequestBody StatusRequestDTO requestDTO);

    /**
     * 支付成功
     *
     * @param payOrderSuccessDTO
     * @return
     */
    @PostMapping(value = "/paySuccess")
    ResultDTO paySuccess(@RequestBody PayOrderSuccessDTO payOrderSuccessDTO);

    /**
     * 取消订单
     *
     * @param orderId
     * @return
     */
    @PostMapping(value = "/cancel")
    ResultDTO cancel(@RequestParam("orderId") String orderId);

    /**
     * 发货
     *
     * @param deliverGoodDTO
     * @return
     */
    @PostMapping(value = "/delivering")
    ResultDTO deliverGoods(@RequestBody DeliverGoodDTO deliverGoodDTO);

    /**
     * 调价
     *
     * @param orderId
     * @param amount
     * @return
     */
    @PostMapping(value = "/adjusting")
    ResultDTO adjustPrice(@RequestParam("orderId") String orderId,@RequestParam("amount") double amount);

    /**
     * 订单超时
     *
     * @param orderId
     * @return
     */
    @PostMapping(value = "/overtime")
    ResultDTO orderOvertime(@RequestParam("orderId") String orderId);
}
