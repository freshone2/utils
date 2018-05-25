package com.common.config.conf;

/**
 * Created by boluome on 2017/5/22.
 */
public enum PayOrderStatus {

    BE_PAID("0","待支付"),
    PAY_PROCESSING("1","支付处理中"),
    PAID("2","已支付"),
    CANCELED("3","交易关闭"),
    REFUND("4","已退款");

    public final String CODE;
    public final String MESSAGE;

    PayOrderStatus(String code , String name){
        this.CODE = code;
        this.MESSAGE = name;
    }
}
