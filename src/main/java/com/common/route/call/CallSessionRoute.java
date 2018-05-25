package com.common.route.call;

import com.common.route.base.SessionRoute;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @Package: com.common.route.call
 * @Description:
 * @author: jklofs
 * @date: 2018/5/11 上午11:36
 */
@FeignClient("service-mms")
public interface CallSessionRoute extends SessionRoute {
}
