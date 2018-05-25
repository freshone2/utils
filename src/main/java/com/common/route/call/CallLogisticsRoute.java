package com.common.route.call;

import com.common.model.dto.ResultDTO;
import com.common.model.dto.logistics.LogisticsDTO;
import com.common.route.base.LogisticsRoute;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Package: pecker.rest
 * @Description:
 * @author: jklofs
 * @date: 2018/4/13 下午7:08
 */
@FeignClient("service-logistics")
public interface CallLogisticsRoute extends LogisticsRoute {
}
