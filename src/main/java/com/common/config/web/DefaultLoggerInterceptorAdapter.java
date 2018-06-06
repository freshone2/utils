package com.common.config.web;

import com.common.filter.LoggerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Package: com.common.config.web
 * @Description:
 * @author: jklofs
 * @date: 2018/6/5 上午2:38
 */
public class DefaultLoggerInterceptorAdapter extends WebMvcConfigurerAdapter {

    @Autowired
    private LoggerInterceptor loggerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(loggerInterceptor).addPathPatterns("/**");
    }


    public LoggerInterceptor getLoggerInterceptor() {
        return loggerInterceptor;
    }

    public void setLoggerInterceptor(LoggerInterceptor loggerInterceptor) {
        this.loggerInterceptor = loggerInterceptor;
    }
}
