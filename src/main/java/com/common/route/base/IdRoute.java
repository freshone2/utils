package com.common.route.base;

import com.common.model.dto.ResultDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Package: pecker.rest
 * @Description:
 * @author: jklofs
 * @date: 2018/4/13 下午7:08
 */
@RequestMapping("/v1")
public interface IdRoute {

    @GetMapping("/id")
    public ResultDTO findId(@RequestHeader("requestId") String requestId, @RequestParam("userId") String userId, @RequestParam("type") Integer type);
}
