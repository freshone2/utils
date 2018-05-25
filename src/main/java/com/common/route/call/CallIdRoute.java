package com.common.route.call;

import com.common.route.base.IdRoute;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @Package: com.common.route.call
 * @Description:
 * @author: jklofs
 * @date: 2018/5/11 下午3:51
 */
@FeignClient("service-common")
public interface CallIdRoute extends IdRoute {
}
