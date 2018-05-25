package com.common.config.conf;

/**
 * @Package: pecker.config.conf
 * @Description:
 * @author: jklofs
 * @date: 2018/4/10 下午4:34
 */
public enum OrderTypeEnum {
    STANDARD(0,"标准订单"),
    GROUP_PURCHASE(1,"团购订单"),
    INTEGRAL(2,"积分订单");


    public final int CODE;
    public final String NAME;

    OrderTypeEnum(int CODE, String NAME) {
        this.CODE = CODE;
        this.NAME = NAME;
    }

    public static OrderIdTypeEnum valueOf(int CODE){
        switch (CODE){
            default:{
                return null;
            }
        }

    }
}
