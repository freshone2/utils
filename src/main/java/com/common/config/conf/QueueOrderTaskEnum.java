package com.common.config.conf;

/**
 * @Package: pecker.config.conf
 * @Description:
 * @author: jklofs
 * @date: 2018/4/9 下午2:27
 */
public enum QueueOrderTaskEnum {
    UPDATE_ORDER_STATUS(0,"修改订单状态"),
    ORDER_OVERTIME(1,"订单超时"),
    UPDATE_ORDER_STATUS_ONLY(2,"仅修改订单状态值"),
    PAY_SUCCESS_ORDER(3,"支付成功"),
    REFUND_SUCCESS_REFUND_ORDER(4,"退款订单退款成功"),
    REFUND_SUCCESS_ORDER(5,"订单退款成功"),
    ORDER_TAKE_OVER_EXPIRE(6,"自动收货"),
    ORDER_COMPLETE_EXPIRE(7,"自动完成")
    ;

    public final int CODE;
    public final String MESSAGE;

    QueueOrderTaskEnum(int CODE, String MESSAGE) {
        this.CODE = CODE;
        this.MESSAGE = MESSAGE;
    }
}
