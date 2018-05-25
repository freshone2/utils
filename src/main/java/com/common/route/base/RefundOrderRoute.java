package com.common.route.base;

import com.common.model.dto.ResultDTO;
import com.common.model.dto.order.RefundUpdateDTO;
import com.common.model.dto.order.StatusRequestDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Package: pecker.rest
 * @Description:
 * @author: jklofs
 * @date: 2018/4/13 下午7:08
 */
@RequestMapping("/v1/refundOrder")
public interface RefundOrderRoute {

    /**
     * 更新退款订单
     *
     * @param requestDTO
     * @return
     */
    @PutMapping("")
    ResultDTO updateRefundOrder(@RequestBody RefundUpdateDTO requestDTO);

    /**
     * 更新退款订单状态（有其他联动操作）
     *
     * @param requestDTO
     * @return
     */
    @PostMapping("/status")
    ResultDTO updateRefundOrderStatus(@RequestBody StatusRequestDTO requestDTO);

    /**
     * 更新退款订单状态（无其他联动操作）
     *
     * @param requestDTO
     * @return
     */
    @PostMapping("/status/only")
    ResultDTO updateRefundOrderStatusOnly(@RequestBody StatusRequestDTO requestDTO);

    /**
     * 退款成功
     *
     * @param refundOrderId
     * @return
     */
    @PostMapping("/refundSuccess")
    ResultDTO refundSuccess(@RequestParam("refundOrderId") String refundOrderId);

    /**
     * 同意退款
     *
     * @param refundOrderId
     * @return
     */
    @PostMapping("/reimburse")
    ResultDTO reimburse(@RequestParam("refundOrderId") String refundOrderId);

    /**
     * 取消退款申请
     *
     * @param refundOrderId
     * @return
     */
    @PostMapping("/cancel")
    ResultDTO cancelRefundOrder(@RequestParam("refundOrderId") String refundOrderId);

    /**
     * 拒绝退款申请
     *
     * @param request
     * @return
     */
    @PostMapping("/request/reject")
    ResultDTO rejectRequestRefundOrder(@RequestBody Map<String,String> request);

    /**
     * 拒绝退货申请
     *
     * @param request
     * @return
     */
    @PostMapping("/good/reject")
    ResultDTO rejectGoodRefundOrder(@RequestBody Map<String,String> request);

    /**
     * 平台端拒绝退款
     *
     * @param request
     * @return
     */
    @PostMapping("/platform/reject")
    ResultDTO rejectPlatformRefundOrder(@RequestBody Map<String,String> request);
}
