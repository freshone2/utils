package com.common.config.conf;

/**
 * Created by wangwei on 2018/8/27.
 */
public enum JgjCouponsStatusEnum {

    HAVENTUSED("HAVENTUSED","未使用"),
    HAVEUSED("HAVEUSED","未使用"),
    EXPIRED("EXPIRED","未使用"),
    NOTHAVEUSED("NOTHAVEUSED","未使用");

    public final String CODE;
    public final String MESSAGE;

    JgjCouponsStatusEnum(String CODE,String MESSAGE) {
        this.CODE = CODE;
        this.MESSAGE=MESSAGE;
    }

}
