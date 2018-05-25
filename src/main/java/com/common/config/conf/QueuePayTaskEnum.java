package com.common.config.conf;

/**
 * @Package: pecker.config.conf
 * @Description:
 * @author: jklofs
 * @date: 2018/4/9 下午2:27
 */
public enum QueuePayTaskEnum {
    UPDATE_PAYMENT_STATUS(0,"修改支付流水状态"),
    UPDATE_PAYMENT(1,"仅修改支付流水值"),
    CANCEL_PAYMENT(2,"取消支付流水");

    public final int CODE;
    public final String MESSAGE;

    QueuePayTaskEnum(int CODE, String MESSAGE) {
        this.CODE = CODE;
        this.MESSAGE = MESSAGE;
    }
}
