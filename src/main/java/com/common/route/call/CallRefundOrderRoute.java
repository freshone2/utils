package com.common.route.call;

import com.common.route.base.RefundOrderRoute;
import org.springframework.cloud.netflix.feign.FeignClient;

import java.util.Map;

/**
 * @Package: pecker.rest
 * @Description:
 * @author: jklofs
 * @date: 2018/4/13 下午7:08
 */
@FeignClient("service-order")
public interface CallRefundOrderRoute extends RefundOrderRoute {
}
