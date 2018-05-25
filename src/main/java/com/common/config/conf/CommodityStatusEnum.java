package com.common.config.conf;

/**
 * Created by boluome on 2017/6/5.
 */
public enum CommodityStatusEnum {
    IN_AUDIT(0,"审核中"),
    ON_SHELF(1,"已上架"),
    AUDIT_FAILURE(2,"审核失败"),
    HALT_SALES(3,"停售"),
    COPIED(4,"复制"),
    OFF_SHELF(5,"已下架"),
    UNPUBLISHED(6,"未发布"),
    FORCED_OFF_SHELF(7,"强制下架"),
    FORCED_LINKAGE_OFF_SHELF(8,"由于上级原因被强制下架"),
    WAITING_FOR_SUBMISSION(10,"待提交"),
    NEW_ADD(11,"新增"),
    IN_PLATFORM(12,"在平台中");

    public final int CODE;
    public final String MESSAGE;

    CommodityStatusEnum(int code, String message) {
        this.CODE = code;
        this.MESSAGE = message;
    }
}
