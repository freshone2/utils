package com.common.model.bo.cache;

import com.common.model.bo.base.ProxyHashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: pecker.model.bo.cache
 * @Description:
 * @author: jklofs
 * @date: 2018/5/2 下午4:26
 */
public class RedisCommodityBo extends ProxyHashMap<String,String> {

    public RedisCommodityBo() {
    }

    public RedisCommodityBo(Map<String, String> map) {
        super(map);
    }

    public RedisCommodityBo(int init) {
        super(init);
    }

    public static final String CONTENT = "content";
    public static final String PURCHASES_COUNT = "purchasesCount";

    public String setContent(String value){
       return put(CONTENT,value);
    }

    public String getContent(){
        return get(CONTENT);
    }

    public String setPurchasesCount(String value){
        return put(PURCHASES_COUNT,value);
    }

    public String getPurchasesCount(){
        return get(PURCHASES_COUNT);
    }
}
