package com.common.model.bo.platform;

import com.common.model.bo.base.ProxyHashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: pecker.model.bo.platform
 * @Description:
 * @author: jklofs
 * @date: 2018/5/14 下午1:58
 */
public class RedisPlatformBo extends ProxyHashMap<String,String> {
    public static final String USED = "used";
    public static final String DISTRIBUTED = "distributed";
    public static final String APP_CODE = "appCode";
    public static final String TARGET = "target";
    public static final String CONTENT = "content";
    public static final String TOTAL = "total";

    public RedisPlatformBo() {
    }

    public RedisPlatformBo(Map<String, String> map) {
        super(map);
    }

    public RedisPlatformBo(int init) {
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
