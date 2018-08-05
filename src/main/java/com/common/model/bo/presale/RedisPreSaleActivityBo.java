package com.common.model.bo.presale;

import com.common.model.bo.base.ProxyHashMap;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Map;

public class RedisPreSaleActivityBo  extends ProxyHashMap<String,String> {
    private static final Gson GSON = new Gson();

    public static final String ID = "id";

    public static final String APP_CODE = "appCode";

    public static final String TITLE = "title";

    public static final String CONTENT = "content";

    public static final String STAGE="stage";

    public RedisPreSaleActivityBo(){}

    public RedisPreSaleActivityBo(Map<String,String> map){
        super(map);
    }

    public int getId(){
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

    public PreSaleActivityContentBo getContent() {
        String contentString = get(CONTENT);
        if (StringUtils.isBlank(contentString)){
            return null;
        }
        return GSON.fromJson(contentString,PreSaleActivityContentBo.class);
    }

    public void setContent(PreSaleActivityContentBo content) {
        put(CONTENT,GSON.toJson(content));
    }

    public int getStage(){
        return NumberUtils.toInt(get(STAGE));
    }

    public void setStage(int stage){
        put(STAGE,String.valueOf(stage));
    }
}
