package com.common.route.call;

import com.common.route.base.PayRoute;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @Package: com.common.route.call
 * @Description:
 * @author: jklofs
 * @date: 2018/5/11 上午11:21
 */
@FeignClient("service-pay")
public interface CallPayRoute extends PayRoute {
}
