package com.common.route.call;

import com.common.route.base.E3Route;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @Package: com.common.route.call
 * @Description:
 * @author: jklofs
 * @date: 2018/5/11 下午12:04
 */
@FeignClient("service-e3")
public interface CallE3Route extends E3Route {
}
