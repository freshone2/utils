package com.common.config.conf;

/**
 * @Package: pecker.config.conf
 * @Description:
 * @author: jklofs
 * @date: 2018/4/18 下午3:05
 */
public enum PayTypeEnum {
    DEFAULT_PAYMENT(0,"整笔支付");

    public final int CODE;
    public final String MESSAGE;

    PayTypeEnum(int CODE, String MESSAGE) {
        this.CODE = CODE;
        this.MESSAGE = MESSAGE;
    }
}
