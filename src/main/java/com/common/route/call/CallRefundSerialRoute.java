package com.common.route.call;

import com.common.route.base.RefundSerialRoute;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @Package: com.common.route.call
 * @Description:
 * @author: jklofs
 * @date: 2018/5/11 上午10:51
 */
@FeignClient("service-refund")
public interface CallRefundSerialRoute extends RefundSerialRoute {
}
