package com.common.model.dto.activity;

import com.common.model.bo.commodity.CommoditySpecificationBo;
import com.common.model.bo.platform.PlatformContentBo;

import java.util.List;

/**
 * @Package: pecker.model.vo
 * @Description:
 * @author: jklofs
 * @date: 2018/5/6 下午1:56
 */
public class CartResponseVo {
    private Integer commodityId;
    private Integer specificationId;
    private Integer no;
    private String commodityName;
    private String specificationName;
    private String icon;
    private Double sellPrice;
    private Integer status;
    private Double originalPrice;
    private Integer num;
    private Integer purchaseNum;
    private Integer commodityFreightType;
    private Integer inventory;
    private Integer promotionNum;
    private Double promotionPrice;
    private Boolean showPromotion;
    private Integer platformActivityId;
    private Boolean finishPlatformActivity = false;
    private PlatformContentBo platformContentBo;
    private Double spread;
    private List<CommoditySpecificationBo> prices;

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public Integer getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Integer specificationId) {
        this.specificationId = specificationId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getSpecificationName() {
        return specificationName;
    }

    public void setSpecificationName(String specificationName) {
        this.specificationName = specificationName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPurchaseNum() {
        return purchaseNum;
    }

    public void setPurchaseNum(Integer purchaseNum) {
        this.purchaseNum = purchaseNum;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCommodityFreightType() {
        return commodityFreightType;
    }

    public void setCommodityFreightType(Integer commodityFreightType) {
        this.commodityFreightType = commodityFreightType;
    }

    public Integer getPromotionNum() {
        return promotionNum;
    }

    public void setPromotionNum(Integer promotionNum) {
        this.promotionNum = promotionNum;
    }

    public Double getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(Double promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public Boolean getShowPromotion() {
        return showPromotion;
    }

    public void setShowPromotion(Boolean showPromotion) {
        this.showPromotion = showPromotion;
    }

    public List<CommoditySpecificationBo> getPrices() {
        return prices;
    }

    public void setPrices(List<CommoditySpecificationBo> prices) {
        this.prices = prices;
    }

    public Integer getPlatformActivityId() {
        return platformActivityId;
    }

    public void setPlatformActivityId(Integer platformActivityId) {
        this.platformActivityId = platformActivityId;
    }

    public Boolean getFinishPlatformActivity() {
        return finishPlatformActivity;
    }

    public void setFinishPlatformActivity(Boolean finishPlatformActivity) {
        this.finishPlatformActivity = finishPlatformActivity;
    }

    public PlatformContentBo getPlatformContentBo() {
        return platformContentBo;
    }

    public void setPlatformContentBo(PlatformContentBo platformContentBo) {
        this.platformContentBo = platformContentBo;
    }

    public Double getSpread() {
        return spread;
    }

    public void setSpread(Double spread) {
        this.spread = spread;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "CartResponseVo{" +
                "commodityId=" + commodityId +
                ", specificationId=" + specificationId +
                ", commodityName='" + commodityName + '\'' +
                ", specificationName='" + specificationName + '\'' +
                ", icon='" + icon + '\'' +
                ", sellPrice=" + sellPrice +
                ", status=" + status +
                ", originalPrice=" + originalPrice +
                ", num=" + num +
                ", purchaseNum=" + purchaseNum +
                ", commodityFreightType=" + commodityFreightType +
                ", inventory=" + inventory +
                ", promotionNum=" + promotionNum +
                ", promotionPrice=" + promotionPrice +
                ", showPromotion=" + showPromotion +
                ", platformActivityId=" + platformActivityId +
                ", finishPlatformActivity=" + finishPlatformActivity +
                ", platformContentBo=" + platformContentBo +
                ", spread=" + spread +
                ", prices=" + prices +
                '}';
    }
}
