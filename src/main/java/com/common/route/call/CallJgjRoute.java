package com.common.route.call;

import com.common.route.base.JgjRoute;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient("service-jgj")
public interface CallJgjRoute extends JgjRoute {
}
