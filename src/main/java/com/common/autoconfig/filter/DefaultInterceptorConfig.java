package com.common.autoconfig.filter;

import com.common.config.web.DefaultLoggerInterceptorAdapter;
import com.common.filter.LoggerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Package: com.common.autoconfig.filter
 * @Description:
 * @author: jklofs
 * @date: 2018/6/4 上午11:55
 */
@Configuration
public class DefaultInterceptorConfig {

    @Bean
    @ConditionalOnProperty(value = "utils.logger.filter" , havingValue = "true")
    public LoggerInterceptor createdLoggerInterceptor(){
        return new LoggerInterceptor();
    }

    @Bean
    @ConditionalOnProperty(value = "utils.logger.filter" , havingValue = "true")
    public DefaultLoggerInterceptorAdapter resigesterLoggerInterceptor(LoggerInterceptor loggerInterceptor){
        DefaultLoggerInterceptorAdapter defaultLoggerInterceptorAdapter = new DefaultLoggerInterceptorAdapter();
        defaultLoggerInterceptorAdapter.setLoggerInterceptor(loggerInterceptor);
        return defaultLoggerInterceptorAdapter;
    }
}
