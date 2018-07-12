package com.common.model.bo.buygift;

import com.common.model.bo.base.ProxyHashMap;
import com.common.model.bo.commodity.CommodityBo;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Map;

/**
 * @Package: com.common.model.bo.buygift
 * @Description:
 * @author: jklofs
 * @date: 2018/7/10 下午6:28
 */
public class RedisBuyGiftSpecificationBo extends ProxyHashMap<String,String> {
    private static final Gson GSON = new Gson();

    public static final String INVENTORY = "inventory";

    public static final String SPECIFICATION_ID = "specificationId";

    public static final String GIFT_NUM = "giftNum";

    public static final String CONTENT = "content";

    public RedisBuyGiftSpecificationBo() {
    }

    public RedisBuyGiftSpecificationBo(Map<String, String> map) {
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

    public int getGiftNum() {
        return NumberUtils.toInt(get(GIFT_NUM));
    }

    public void setGiftNum(int giftNum){
        put(GIFT_NUM, String.valueOf(giftNum));
    }

    public GiftCommodityBo getCONTENT() {
        String commodityString = get(CONTENT);
        if (StringUtils.isBlank(commodityString)){
            return null;
        }
        return GSON.fromJson(commodityString,GiftCommodityBo.class);
    }

    public void setContent(CommodityBo content){
        put(CONTENT,GSON.toJson(content));
    }
}
