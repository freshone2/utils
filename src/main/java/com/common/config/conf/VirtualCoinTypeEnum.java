package com.common.config.conf;

/**
 * @Package: com.common.config.conf
 * @Description:
 * @author: jklofs
 * @date: 2018/5/19 下午2:16
 */
public enum VirtualCoinTypeEnum {
    GRANT(1),
    RESTORATION(2),
    CONSUMPTION(-1),
    EXPIRE(-2);

    public final int CODE;

    VirtualCoinTypeEnum(int CODE) {
        this.CODE = CODE;
    }
}
