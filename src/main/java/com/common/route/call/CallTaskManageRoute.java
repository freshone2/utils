package com.common.route.call;

import com.common.route.base.TaskManageRoute;
import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @Package: com.common.route.call
 * @Description:
 * @author: jklofs
 * @date: 2018/5/11 下午12:24
 */
@FeignClient("service-task")
public interface CallTaskManageRoute extends TaskManageRoute {
}
