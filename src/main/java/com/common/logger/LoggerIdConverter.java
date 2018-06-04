package com.common.logger;

import ch.qos.logback.classic.pattern.ClassicConverter;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.util.WebUtils;

/**
 * @Package: com.common.logger
 * @Description:
 * @author: jklofs
 * @date: 2018/6/4 上午10:28
 */
public class LoggerIdConverter extends ClassicConverter {
    @Override
    public String convert(ILoggingEvent iLoggingEvent) {
        return String.valueOf(System.nanoTime())+iLoggingEvent.getLoggerName().hashCode();
    }
}
