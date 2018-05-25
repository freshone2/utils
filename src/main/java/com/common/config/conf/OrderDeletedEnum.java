package com.common.config.conf;

/**
 * @Package: com.common.config.conf
 * @Description:
 * @author: jklofs
 * @date: 2018/5/4 下午10:09
 */
public enum OrderDeletedEnum {
    VIEW(0),
    DELETED(1)
    ;
    public final int CODE;

    OrderDeletedEnum(int CODE) {
        this.CODE = CODE;
    }
}
