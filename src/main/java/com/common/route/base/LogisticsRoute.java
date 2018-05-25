package com.common.route.base;

import com.common.model.dto.ResultDTO;
import com.common.model.dto.logistics.LogisticsDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Package: pecker.rest
 * @Description:
 * @author: jklofs
 * @date: 2018/4/13 下午7:08
 */
@RequestMapping("/v1")
public interface LogisticsRoute {

    /**
     * 更新
     *
     * @param logisticsDTO
     * @return
     */
    @PostMapping("/logistics")
    ResultDTO addLogistics(@RequestBody LogisticsDTO logisticsDTO);

}
