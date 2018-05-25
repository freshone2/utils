package com.common.config.conf;

/**
 * @Package: pecker.config.conf
 * @Description:
 * @author: jklofs
 * @date: 2018/4/9 下午2:27
 */
public enum QueueRefundTaskEnum {
    UPDATE_REFUNDMENT_STATUS(0,"修改退款流水状态"),
    UPDATE_PAYMENT(1,"仅修改退款流水值"),
    CANCEL_PAYMENT(2,"取消退款流水");

    public final int CODE;
    public final String MESSAGE;

    QueueRefundTaskEnum(int CODE, String MESSAGE) {
        this.CODE = CODE;
        this.MESSAGE = MESSAGE;
    }
}
