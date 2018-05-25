package com.common.route.call;

import com.common.route.base.PromotionRoute;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @Package: com.common.route.call
 * @Description:
 * @author: jklofs
 * @date: 2018/5/19 下午7:04
 */
@FeignClient("service-promotion")
public interface CallPromotionRoute extends PromotionRoute {
}
