package com.common.config.conf;

/**
 * @Package: pecker.config.conf
 * @Description:
 * @author: jklofs
 * @date: 2018/5/15 下午4:01
 */
public enum CouponEnum {
    FULL_AMOUNT_SUBTRACTION(0),
    FULL_AMOUNT_FOLDING(1);

    public final int CODE;

    CouponEnum(int CODE) {
        this.CODE = CODE;
    }
}
