package com.common.config.conf;

/**
 * @Package: pecker.config.conf
 * @Description:
 * @author: jklofs
 * @date: 2018/4/26 下午3:19
 */
public enum LogisticsEnum {
    ORDER_LOGISTICS(0),
    REFUND_ORDER_LOGISTICS(1)
    ;

    public final int CODE;

    LogisticsEnum(int CODE) {
        this.CODE = CODE;
    }

    public static LogisticsEnum valueOf(int code){
        switch (code){
            case 0:{
                return ORDER_LOGISTICS;
            }
            case 1:{
                return REFUND_ORDER_LOGISTICS;
            }
            default:{
                return ORDER_LOGISTICS;
            }
        }
    }
}
