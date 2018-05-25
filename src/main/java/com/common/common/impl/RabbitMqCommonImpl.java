package com.common.common.impl;

import com.common.common.RabbitMqCommon;
import com.common.config.RabbitConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.UUID;

/**
 * @Package: pecker.service.common.impl
 * @Description:
 * @author: jklofs
 * @date: 2018/4/8 下午5:51
 */
@ConditionalOnClass(RabbitTemplate.class)
@ConditionalOnBean(RabbitTemplate.class)
@EnableConfigurationProperties(RabbitConfig.class)
public class RabbitMqCommonImpl implements RabbitMqCommon {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMqCommonImpl.class);

    private RabbitTemplate rabbitTemplate;

    private RabbitConfig rabbitConfig;

    @Override
    public boolean sendOrderMessage(String content) {
        return sendMessage(rabbitConfig.getOrderExchange(), rabbitConfig.getOrderRoutingKey(),content);
    }

    @Override
    public boolean sendRefundMessage(String content) {
        return sendMessage(rabbitConfig.getRefundExchange(), rabbitConfig.getRefundRoutingKey(),content);
    }

    @Override
    public boolean sendPayMessage(String content) {
        return sendMessage(rabbitConfig.getPayExchange(), rabbitConfig.getPayRoutingKey(),content);
    }

    @Override
    public boolean sendActivityMessage(String content) {
        return sendMessage(rabbitConfig.getPayExchange(), rabbitConfig.getPayRoutingKey(),content);
    }

    private boolean sendMessage(String exchange,String routingKey,String content){
        Message message = MessageBuilder.withBody(content.getBytes())
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .setContentEncoding("utf-8").setMessageId(UUID.randomUUID()+"").build();
        rabbitTemplate.convertAndSend(exchange,routingKey, message  );
        return true;
    }

    public RabbitTemplate getRabbitTemplate() {
        return rabbitTemplate;
    }

    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public RabbitConfig getRabbitConfig() {
        return rabbitConfig;
    }

    public void setRabbitConfig(RabbitConfig rabbitConfig) {
        this.rabbitConfig = rabbitConfig;
    }
}
