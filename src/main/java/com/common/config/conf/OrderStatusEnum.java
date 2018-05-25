package com.common.config.conf;

/**
 * @Package: pecker.config
 * @Description:
 * @author: jklofs
 * @date: 2018/3/30 上午11:29
 */
public enum OrderStatusEnum {
    REMOVE(-1,"已删除","已删除","已删除","已删除"),
    ERROR(0,"异常","异常","异常","异常"),
    BE_PAID(10,"待支付","待支付","待支付","待支付"),
    CANCELLED(20,"交易关闭","交易关闭","交易关闭","交易关闭"),
    WAITING_REGIMENT(30,"待成团","待成团","待成团","待成团"),
    PENDING_DELIVERY(40,"待发货","待发货","待发货","待发货"),
    ALREADY_SHIPPED(50,"已发货","已发货","已发货","已发货"),
    WAITING_EVALUATION(60,"待评价","待评价","待评价","待评价"),
    COMPLETE(70,"已完成","已完成","已完成","已完成"),
    REFUNDING(80,"退款中","退款中","退款中","退款中"),
    PAY_BACK_SUCCESS(90,"退款成功","退款成功","退款成功","退款成功");

    public final int CODE;
    public final String CHILD_NAME;
    public final String ORDER_NAME;
    public final String SHOP_NAME;
    public final String PLATFORM_NAME;

    OrderStatusEnum(int CODE, String CHILD_NAME, String ORDER_NAME, String SHOP_NAME, String PLATFORM_NAME) {
        this.CODE = CODE;
        this.CHILD_NAME = CHILD_NAME;
        this.ORDER_NAME = ORDER_NAME;
        this.SHOP_NAME = SHOP_NAME;
        this.PLATFORM_NAME = PLATFORM_NAME;
    }

    public static OrderStatusEnum valueOf(int code){
        switch (code){
            case 10:{
                return BE_PAID;
            }
            case 20:{
                return CANCELLED;
            }
            case 30:{
                return WAITING_REGIMENT;
            }
            case 40:{
                return PENDING_DELIVERY;
            }
            case 50:{
                return ALREADY_SHIPPED;
            }
            case 60:{
                return WAITING_EVALUATION;
            }
            case 70:{
                return COMPLETE;
            }
            case 80:{
                return REFUNDING;
            }
            case 90:{
                return PAY_BACK_SUCCESS;
            }
            case 0:{
                return ERROR;
            }
            case -1:{
                return REMOVE;
            }
            default:{
                return REMOVE;
            }
        }
    }
}
