package com.common.route.call;

import com.common.route.base.MallInSideRoute;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @Package: com.common.route.call
 * @Description:
 * @author: jklofs
 * @date: 2018/5/31 下午4:10
 */
@FeignClient("service-mall")
public interface CallMallInSideRoute extends MallInSideRoute {
}
