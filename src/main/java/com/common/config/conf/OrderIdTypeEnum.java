package com.common.config.conf;

/**
 * @Package: pecker.config
 * @Description:
 * @author: jklofs
 * @date: 2018/3/30 下午4:54
 */
public enum OrderIdTypeEnum {
    SHOP_ORDER(0,"店铺订单"),
    GOOD_ORDER(1,"商品订单"),
    REFUND_ORDER(2,"退款申请单"),
    PAY_SERIALNUMBER(3,"支付流水号"),
    REFUND_SERIALNUMBER(4,"退款流水号")
    ;

    public final int CODE;
    public final String NAME;

    OrderIdTypeEnum(int CODE, String NAME) {
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
