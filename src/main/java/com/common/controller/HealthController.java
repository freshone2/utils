package com.common.controller;

import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package: com.common.controller
 * @Description:
 * @author: jklofs
 * @date: 2018/6/29 下午4:37
 */
@RestController
public class HealthController {

    @RequestMapping("/")
    public String index() {
        return "hello world";
    }
}