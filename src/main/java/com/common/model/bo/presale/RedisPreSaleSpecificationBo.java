package com.common.model.bo.presale;

import com.common.model.bo.base.ProxyHashMap;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Map;

public class RedisPreSaleSpecificationBo  extends ProxyHashMap<String,String> {
    private static final Gson GSON = new Gson();

    public static final String INVENTORY = "inventory";

    public static final String SPECIFICATION_ID = "specificationId";

    public static final String CONTENT = "content";

    public RedisPreSaleSpecificationBo(){}

    public RedisPreSaleSpecificationBo(Map<String,String> map){
        super(map);
    }

    public int getInventory() {
        return NumberUtils.toInt(get(INVENTORY));
    }

    public void setInventory(int inventory){
        put(INVENTORY, String.valueOf(inventory));
    }

    public int getSpecificationId() {
        return NumberUtils.toInt(get(SPECIFICATION_ID));
    }

    public void setSpecificationId(int specificationId){
        put(SPECIFICATION_ID, String.valueOf(specificationId));
    }

    public PreSaleSpecificationContentBo getCONTENT() {
        String commodityString = get(CONTENT);
        if (StringUtils.isBlank(commodityString)){
            return null;
        }
        return GSON.fromJson(commodityString,PreSaleSpecificationContentBo.class);
    }

    public void setContent(PreSaleSpecificationContentBo content){
        put(CONTENT,GSON.toJson(content));
    }
}
