package com.common.model.bo.buygift;

import com.common.model.bo.commodity.CommodityBo;

import java.util.List;

/**
 * @Package: com.common.model.bo.buygift
 * @Description:
 * @author: jklofs
 * @date: 2018/7/12 上午11:35
 */
public class BuyGiftActivityDetailBo extends BuyGiftActivityContentBo {
    private List<GiftCommodityBo> gifts;

    public List<GiftCommodityBo> getGifts() {
        return gifts;
    }

    public void setGifts(List<GiftCommodityBo> gifts) {
        this.gifts = gifts;
    }

    @Override
    public String toString() {
        return "BuyGiftActivityDetailBo{" +
                "super=" + super.toString() +
                "gifts=" + gifts +
                '}';
    }
}
