package com.common.model.dao.redis;

/**
 * @Package: com.common.model.dao.redis
 * @Description:
 * @author: jklofs
 * @date: 2018/7/11 上午11:35
 */
public interface ActivityPrefix {
    int ACTIVITY_DB = 5;

    /**
     * 优惠券key:this+appCode+ID
     */
    String COUPON_PREFIX = "a:c";

    /**
     * 活动关联的商品Key:this+appCode+userID
     */
    String ACTIVITY_SPECIFICATION_PREFIX = "a:s";

    /**
     * 上线的优惠券活动key:this+appCode
     */
    String ONLINE_COUPON_ACTIVITY = "ooca";

    /**
     * 平台活动key:this+appCode+ID
     */
    String PLATFORM_PREFIX = "a:p";

    /**
     * 上线的平台活动key:this+appCode
     */
    String ONLINE_PLATFORM_ACTIVITY = "oopa";

    /**
     * 规格反向关联活动key:this+appCode+规格ID
     */

    String SPECIFICATION_ACTIVITY_PREFIX = "s:a";

    /**
     * 用户优惠券列表key:this+appCode+userId
     */

    String USER_COUPON = "u:c";

    String USER_COUPON_SPLIT_CODE = "-";

    String USER_COUPON_USED_SUFFIX = "used";

    String USER_COUPON_OVERTIME_SUFFIX = "overtime";

    /**
     * 券ID自增
     */
    String COUPON_ID_PREFIX = "c:i";

    /**
     * 用户券领取次数：this+券类型ID+userId
     */
    String COUPON_USER_GIVE = "c:g";

    /**
     * 用户参与平台活动次数：this+平台活动ID+userId
     */
    String PLATFORM_USER_USED = "p:g";

    String USER_COUPON_GIVE_TOTAL = "total";

    String USER_PLATFORM_TOTAL = "total";

    /**
     * 限时折扣：this+appCode+商品ID
     */
    String SPECIAL_ACTIVITY_PREFIX = "a:sp";

    /**
     * 用户参与限时折扣次数：this+appCode+商品ID
     */
    String USER_SPECIAL_COMMODITY_PREFIX = "u:sp";

    String USER_SPECIAL_COMMODITY_SPLIT_CODE = "-";

    String BUY_GIFT_ACTIVITY_PREFIX = "a:bg";

    String BUY_GIFT_ACTIVITY_GIFT_PREFIX = "a:bg:gift";

    /**
     * 上线的买赠活动key:this+id
     */
    String ONLINE_BUY_GIFT_ACTIVITY = "obga";
}
