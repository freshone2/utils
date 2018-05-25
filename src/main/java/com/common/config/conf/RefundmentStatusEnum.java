package com.common.config.conf;

/**
 * Created by boluome on 2017/5/22.
 */
public enum RefundmentStatusEnum {

    BE_REFUND("0","待退款"),
    REFUND_PROCESSING("1","退款中"),
    REFUNDED("2","已退款"),
    CANCELED("3","交易关闭");

    public final String CODE;
    public final String MESSAGE;

    RefundmentStatusEnum(String code , String name){
        this.CODE = code;
        this.MESSAGE = name;
    }
}
