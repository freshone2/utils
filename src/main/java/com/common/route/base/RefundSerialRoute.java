package com.common.route.base;

import com.common.model.dto.ResultDTO;
import com.common.model.dto.refundSerial.RefundSerialDTO;
import com.common.model.dto.refundSerial.RefundSerialSuccessDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Package: pecker.rest
 * @Description:
 * @author: jklofs
 * @date: 2018/4/18 下午4:22
 */
@RequestMapping("/v1/refundment")
public interface RefundSerialRoute {

    /**
     * 创建退款流水
     *
     * @param serialDTO
     * @return
     */
    @PostMapping("")
    ResultDTO createdRefundment(@RequestHeader("requestId") String requestId,@RequestBody RefundSerialDTO serialDTO);

    /**
     * 修改退款流水
     *
     * @param serialDTO
     * @return
     */
    @PutMapping("")
    ResultDTO updateRefundment(@RequestHeader("requestId") String requestId,@RequestBody RefundSerialDTO serialDTO);

    /**
     * 退款流水退款成功
     *
     * @param serialDTO
     * @return
     */
    @PostMapping("/refundSuccess")
    ResultDTO refundSuccess(@RequestHeader("requestId") String requestId,@RequestBody RefundSerialSuccessDTO serialDTO);

    /**
     * 取消退款流水
     *
     * @param serialDTO
     * @return
     */
    @PostMapping("/cancel")
    ResultDTO cancel(@RequestHeader("requestId") String requestId,@RequestBody Map<String,String> serialDTO);

}
