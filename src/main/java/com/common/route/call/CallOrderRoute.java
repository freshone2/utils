package com.common.route.call;

import com.common.route.base.OrderRoute;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @Package: pecker.rest
 * @Description:
 * @author: jklofs
 * @date: 2018/4/13 下午7:00
 */
@FeignClient("service-order")
public interface CallOrderRoute extends OrderRoute {
}
