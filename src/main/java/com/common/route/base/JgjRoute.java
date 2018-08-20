package com.common.route.base;

import com.common.model.dto.ResultDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/jgj")
public interface JgjRoute {

    @GetMapping("/v1/order")
    ResultDTO syncOrderToJgj(@RequestParam("orderId") String orderId);
}
