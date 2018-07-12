package com.common.model.bo.buygift;

import com.common.model.bo.commodity.CommodityBo;

/**
 * @Package: com.common.model.bo.buygift
 * @Description:
 * @author: jklofs
 * @date: 2018/7/12 下午1:43
 */
public class GiftCommodityBo extends CommodityBo {
    private Integer inventory;

    private Integer giftNum;

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getGiftNum() {
        return giftNum;
    }

    public void setGiftNum(Integer giftNum) {
        this.giftNum = giftNum;
    }

    @Override
    public String toString() {
        return "GiftCommodityBo{" +
                "super=" + super.toString() +
                "inventory=" + inventory +
                ", giftNum=" + giftNum +
                '}';
    }
}
