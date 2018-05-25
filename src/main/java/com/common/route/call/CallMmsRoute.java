package com.common.route.call;

import com.common.route.base.MmsRoute;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @Package: com.common.route.call
 * @Description:
 * @author: jklofs
 * @date: 2018/5/19 下午7:03
 */
@FeignClient("service-mms")
public interface CallMmsRoute extends MmsRoute {
}
