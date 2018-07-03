package com.common.autoconfig.feign;

import feign.Feign;
import okhttp3.ConnectionPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.netflix.feign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @Package: pecker.config
 * @Description:
 * @author: jklofs
 * @date: 2018/6/26 下午12:43
 */
@Configuration
@ConditionalOnClass(Feign.class)
@ConditionalOnProperty(value = "feign.okhttp.enabled" ,havingValue = "true")
@AutoConfigureBefore(FeignAutoConfiguration.class)
public class FeignOkHttpConfig {
    private static final Logger LOGGER = LoggerFactory.getLogger(FeignOkHttpConfig.class);

    @Value("${utils.okhttp.readTimeout:3000}")
    private Integer readTimeout;

    @Value("${utils.okhttp.connectTimeout:3000}")
    private Integer connectTimeout;

    @Value("${utils.okhttp.writeTimeout:3000}")
    private Integer writeTimeout;

    @Value("${utils.okhttp.maxIdleConnections:3000}")
    private Integer maxIdleConnections;

    @Value("${utils.okhttp.keepAliveDuration:30000}")
    private Integer keepAliveDuration;

    @Bean
    @ConditionalOnProperty(value = "feign.okhttp.enabled" ,havingValue = "true")
    public okhttp3.OkHttpClient okHttpClient(){
        LOGGER.info("OkHttpClient创建........");
        return new okhttp3.OkHttpClient.Builder()
                .readTimeout(readTimeout, TimeUnit.MILLISECONDS)
                .connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
                .writeTimeout(writeTimeout, TimeUnit.MILLISECONDS)
                .connectionPool(new ConnectionPool(maxIdleConnections,keepAliveDuration,TimeUnit.MILLISECONDS))
                .build();
    }
}
