package com.common.config.conf;

/**
 * 拼团订单类型
 * 
 * @author xiangshuo
 *
 */
public enum  OrderGroupTypeEnum {
    LEADER_NOT_FREE("00"),	// 团长非免单
    LEADER_FREE("01"),	// 团长免单
    FREIND_HELP("02"),	// 好友助力
    TRY("03")	// 免费试用
    ;

    public final String CODE;


    OrderGroupTypeEnum(String CODE) {
        this.CODE = CODE;
    }
}
