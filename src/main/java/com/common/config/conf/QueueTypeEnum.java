package com.common.config.conf;

/**
 * @Package: pecker.config.conf
 * @Description:
 * @author: jklofs
 * @date: 2018/4/12 上午11:24
 */
public enum QueueTypeEnum {
    ORDER(0,"订单中心队列"),
    PAY(1,"支付中心队列"),
    REFUND(2,"退款中心队列");

    public final int CODE;
    public final String MESSAGE;

    QueueTypeEnum(int CODE, String MESSAGE) {
        this.CODE = CODE;
        this.MESSAGE = MESSAGE;
    }
}
