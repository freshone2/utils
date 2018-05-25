package com.common.config.conf;

/**
 * @Package: pecker.config.conf
 * @Description:
 * @author: jklofs
 * @date: 2018/5/15 下午4:05
 */
public enum PlatformActivityEnum {
    FULL_AMOUNT_SUBTRACTION(0),
    FULL_AMOUNT_FOLDING(1),
    FULL_NUM_SUBTRACTION(2),
    FULL_NUM_FOLDING(3);

    public final int CODE;

    PlatformActivityEnum(int CODE) {
        this.CODE = CODE;
    }
}
