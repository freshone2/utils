package com.common.config.conf;

public enum TaskEnum {
    SCENE_ACTIVITY_ONLINE(0,"场景活动上线管理"),
    SCENE_ACTIVITY_OFFLINE(1,"场景活动下线管理"),
    SCENE_COUPON_ONLINE(2,"场景活动优惠券上线管理"),
    ORDER_EMAIL_REMINDING(3,"订单邮件提醒"),
    ORDER_MESSAGE_REMINDING(4,"订单短信提醒"),
    ORDER_TIMEOUT_CANCEL(5,"订单超时取消"),
    DELAY_QUEUE_TASK(6,"延迟队列型任务"),
    ;

    public final int CODE;
    public final String NAME;

    TaskEnum(int CODE, String NAME) {
        this.CODE = CODE;
        this.NAME = NAME;
    }

    public static TaskEnum valueOf(int code){
        switch (code){
            case 0:{
                return SCENE_ACTIVITY_ONLINE;
            }
            case 1:{
                return SCENE_ACTIVITY_OFFLINE;
            }
            case 2:{
                return SCENE_COUPON_ONLINE;
            }
            case 3:{
                return ORDER_EMAIL_REMINDING;
            }
            case 4:{
                return ORDER_MESSAGE_REMINDING;
            }
            case 5:{
                return ORDER_TIMEOUT_CANCEL;
            }
            case 6:{
                return DELAY_QUEUE_TASK;
            }
            default:{
                return null;
            }
        }
    }
}
