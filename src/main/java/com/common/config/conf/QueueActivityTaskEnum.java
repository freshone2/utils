package com.common.config.conf;

/**
 * @Package: com.common.config.conf
 * @Description:
 * @author: jklofs
 * @date: 2018/5/10 上午9:11
 */
public enum QueueActivityTaskEnum {
    //TODO 定义活动类型对象
    ;

    public final int CODE;
    public final String MESSAGE;

    QueueActivityTaskEnum(int CODE, String MESSAGE) {
        this.CODE = CODE;
        this.MESSAGE = MESSAGE;
    }
}
