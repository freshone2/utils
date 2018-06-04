package com.common.route.base;

import com.common.model.dto.ResultDTO;
import org.springframework.web.bind.annotation.*;

/**
 * @Package: pecker.rest
 * @Description:
 * @author: jklofs
 * @date: 2017/9/29 下午4:09
 */
public interface SessionRoute {

    /**
     * 修改session值
     *
     * @param sessionString
     * @return
     */
    @PutMapping(value = "/v1/session")
    ResultDTO update(@RequestHeader("requestId") String requestId,@RequestParam("sessionString") String sessionString);

    /**
     * 删除session
     *
     * @param sessionId
     * @return
     */
    @DeleteMapping(value = "/v1/session")
    ResultDTO delete(@RequestHeader("requestId") String requestId,@RequestParam("sessionId") String sessionId);

    /**
     * 新增session
     *
     * @param sessionString
     * @return
     */
    @PostMapping(value = "/v1/session")
    ResultDTO doCreate(@RequestHeader("requestId") String requestId,@RequestParam("sessionString") String sessionString);

    /**
     * 查询session
     *
     * @param sessionId
     * @return
     */
    @GetMapping(value = "/v1/session")
    ResultDTO doReadSession(@RequestHeader("requestId") String requestId,@RequestParam("sessionId") String sessionId);

    /**
     * 获取活动的session的对象
     *
     * @return
     */
    @GetMapping(value = "/v1/session/activity")
    ResultDTO getActiveSessions();

    /**
     * 获取权限值
     *
     * @param systemKey
     * @param userName
     * @return
     */
    @GetMapping(value = "/v1/perms")
    ResultDTO findPermissions(@RequestHeader("requestId") String requestId,@RequestParam("systemKey") String systemKey
            ,@RequestParam("userName") String userName);
}
