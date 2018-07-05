package com.common.common;

/**
 * @Package: pecker.utils
 * @Description:
 * @author: jklofs
 * @date: 2018/4/8 下午5:49
 */
public interface RabbitMqCommon {

    /**
     * 发送订单中心发送消息
     *
     * @return
     */
    boolean sendOrderMessage(String content);

    /**
     * 向退款中心发送消息
     *
     * @param content
     * @return
     */
    boolean sendRefundMessage(String content);

    /**
     * 向支付中心发送消息
     *
     * @param content
     * @return
     */
    boolean sendPayMessage(String content);

    /**
     * 向活动中心推送消息
     *
     * @param content
     * @return
     */
    boolean sendActivityMessage(String content);

    /**
     * 向crm新增轮询
     *
     * @param content
     * @return
     */
    boolean sendCrmMessage(String content);
}
