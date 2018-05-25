package com.common.model.bo.coupon;

import com.common.model.bo.base.ProxyHashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: pecker.model.bo.coupon
 * @Description:
 * @author: jklofs
 * @date: 2018/5/14 上午10:36
 */
public class RedisActivityCouponBo extends ProxyHashMap<String,String> {
    public static final String USED = "used";
    public static final String CONTENT = "content";
    public static final String DISTRIBUTED = "distributed";
    public static final String APP_CODE = "appCode";
    public static final String TARGET = "target";
    public static final String TOTAL = "total";

    public RedisActivityCouponBo() {
    }

    public RedisActivityCouponBo(Map<String, String> map) {
        super(map);
    }

    public RedisActivityCouponBo(int init) {
        super(init);
    }

    public String getUsed() {
        return get(USED);
    }

    public void setUsed(String used) {
        put(USED,used);
    }

    public String getContent() {
        return get(CONTENT);
    }

    public void setContent(String content) {
        put(CONTENT,content);
    }

    public String getDistributed() {
        return get(DISTRIBUTED);
    }

    public void setDistributed(String distributed) {
        put(DISTRIBUTED,distributed);
    }

    public String getAppCode() {
        return get(APP_CODE);
    }

    public void setAppCode(String appCode) {
        put(APP_CODE,appCode);
    }

    public String getTarget() {
        return get(TARGET);
    }

    public void setTarget(String target) {
        put(TARGET,target);
    }

    public String getTotal() {
        return get(TOTAL);
    }

    public void setTotal(String total) {
        put(TOTAL,total);
    }
}
