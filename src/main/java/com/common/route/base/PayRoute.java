package com.common.route.base;

import com.common.model.dto.ResultDTO;
import com.common.model.dto.pay.JahwaRefundDTO;
import com.common.model.dto.pay.PaySerialDTO;
import com.common.model.dto.pay.PaySerialSuccessDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Package: pecker.rest
 * @Description:
 * @author: jklofs
 * @date: 2018/4/18 下午4:22
 */
@RequestMapping("/v1/payment")
public interface PayRoute {

    @PostMapping(value = "")
    ResultDTO createdPayment(@RequestBody PaySerialDTO paySerialDTO);

    @PutMapping(value = "")
    ResultDTO updatePaySerialNum(@RequestBody PaySerialDTO paySerialDTO);

    @PostMapping(value = "/cancel")
    ResultDTO cancel(@RequestBody Map<String,String> request);

    @PostMapping(value = "/paySuccess")
    ResultDTO paySuccess(@RequestBody PaySerialSuccessDTO paySuccessDTO);

    @PostMapping(value = "/jahwaRefund")
    ResultDTO refundOrder(@RequestBody JahwaRefundDTO jahwaRefundDTO);
}
