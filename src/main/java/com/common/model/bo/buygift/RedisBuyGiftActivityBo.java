package com.common.model.bo.buygift;

import com.common.model.bo.base.ProxyHashMap;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * @Package: com.common.model.bo.buygift
 * @Description:
 * @author: jklofs
 * @date: 2018/7/10 下午5:38
 */
public class RedisBuyGiftActivityBo extends ProxyHashMap<String,String> {
    private static final Gson GSON = new Gson();

    public static final Type INTEGER_LIST_TYPE = new TypeToken<List<Integer>>(){}.getType();

    public static final String ID = "id";

    public static final String APP_CODE = "appCode";

    public static final String TITLE = "title";

    public static final String MAX_PURCHASED = "maxPurchased";

    public static final String EXPIRE = "expire";

    public static final String TARGET = "target";

    public static final String GIFT_IDS = "giftIds";

    public static final String CONTENT = "content";

    public RedisBuyGiftActivityBo(Map<String, String> map) {
        super(map);
    }

    public int getID() {
        return NumberUtils.toInt(get(ID));
    }

    public void setId(int id){
        put(ID, String.valueOf(id));
    }

    public String getAppCode() {
        return get(APP_CODE);
    }

    public void setAppCode(String appCode){
        put(APP_CODE,appCode);
    }

    public String getTitle() {
        return get(TITLE);
    }

    public void setTitle(String title){
        put(TITLE,title);
    }

    public int getMaxPurchased() {
        return NumberUtils.toInt(get(MAX_PURCHASED));
    }

    public void setMaxPurchased(int maxPurchased){
        put(MAX_PURCHASED,Integer.toString(maxPurchased));
    }

    public long getEXPIRE() {
        return NumberUtils.toLong(get(EXPIRE));
    }

    public void setExpire(long expire){
        put(EXPIRE, String.valueOf(expire));
    }

    public List<Integer> getGiftIds() {
        String specificationString = get(GIFT_IDS);
        if (StringUtils.isBlank(specificationString)){
            return null;
        }
        return GSON.fromJson(specificationString, INTEGER_LIST_TYPE);
    }

    public void setGiftIds(List<Integer> giftIds) {
        put(GIFT_IDS,GSON.toJson(giftIds));
    }


    public BuyGiftActivityContentBo getContent() {
        String contentString = get(CONTENT);
        if (StringUtils.isBlank(contentString)){
            return null;
        }
        return GSON.fromJson(contentString,BuyGiftActivityContentBo.class);
    }

    public void setContent(BuyGiftActivityContentBo content) {
        put(CONTENT,GSON.toJson(content));
    }

    public String getTarget() {
        return get(TARGET);
    }

    public void setTarget(String target) {
        put(TARGET,target);
    }
}
