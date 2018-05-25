package com.common.config.conf;

/**
 * @Package: pecker.config.conf
 * @Description:
 * @author: jklofs
 * @date: 2018/4/11 下午2:27
 */
public enum AdjustAmountTypeEnum {
    CAN_ADJUST(0,true),
    CAN_NOT_ADJUST(1,false);

    public final int CODE;
    public final boolean CHECK;

    AdjustAmountTypeEnum(int CODE, boolean CHECK) {
        this.CODE = CODE;
        this.CHECK = CHECK;
    }

    public static AdjustAmountTypeEnum valueOf(Integer CODE){
        switch (CODE){
            case 0:{
                return CAN_ADJUST;
            }
            case 1:{
                return CAN_NOT_ADJUST;
            }
            default:{
                return CAN_NOT_ADJUST;
            }
        }
    }
}
