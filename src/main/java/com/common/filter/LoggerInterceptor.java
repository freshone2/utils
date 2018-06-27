package com.common.filter;

import com.common.utils.PingAnLoggerUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Package: com.common.filter
 * @Description:
 * @author: jklofs
 * @date: 2018/6/4 上午9:51
 */
public class LoggerInterceptor implements HandlerInterceptor {
    public static final String APP_CODE = "appCode";
    public static final String REQUEST_ID = "requestId";
    public static final String INTERFACE_TYPE = "同步";
//    public static final String SERVER_IP = "server";

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String appCode = httpServletRequest.getHeader(APP_CODE);
        String requestId = httpServletRequest.getHeader(REQUEST_ID);
        PingAnLoggerUtils.setAppCode(appCode);
        if (StringUtils.isBlank(requestId)) {
            requestId = UUID.randomUUID().toString().replace("-","");
        }
        PingAnLoggerUtils.setRequestId(requestId);
        PingAnLoggerUtils.setFROM(httpServletRequest.getRemoteAddr());
        PingAnLoggerUtils.setTO(httpServletRequest.getLocalAddr());
        PingAnLoggerUtils.setInterfaceId(httpServletRequest.getRequestURI());
        PingAnLoggerUtils.setInterfaceName(httpServletRequest.getRequestURI());
        PingAnLoggerUtils.setServerIp(httpServletRequest.getLocalAddr());
        PingAnLoggerUtils.setInterfaceType(INTERFACE_TYPE);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//        System.out.println("ewewqewqeqwewqeqweqwewqewqwewqewqewqewqewqeqwewq");
//        httpServletResponse.addHeader(SERVER_IP,"ghhjgjgjhghjgjgjgjhgjh");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse
            , Object o, Exception e) throws Exception {
    }
}
