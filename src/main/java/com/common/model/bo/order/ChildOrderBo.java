package com.common.model.bo.order;

import com.common.model.bo.commodity.CommodityBo;

import java.util.List;

/**
 * @Package: pecker.model.bo.order
 * @Description:
 * @author: jklofs
 * @date: 2018/3/30 上午10:03
 */
public class ChildOrderBo extends BaseOrderBo {

    private String goodName;
    //用户相关价格
    private Double unitPrice;
    private Double realPrice;
    private Double unitIntegral;
    private Double integral;
    //平台相关价格
    private Double unitBasePrice;
    private Double basePrice;
    private Integer num;
    private String specName;
    private Integer goodId;
    private String goodNo;
    private Integer specId;
    private String specNo;
    private String store;
    //店铺code
    private String brandCode;
    private OrderActivityBo platform;
    private OrderActivityBo coupon;
    private OrderActivityBo specialActivity;
    private OrderVirtualCoinBo virtualCoin;
    private CommodityBo relationGood;
    private String commodityAmount;

    public String getGoodNo() {
        return goodNo;
    }

    public void setGoodNo(String goodNo) {
        this.goodNo = goodNo;
    }

    public String getSpecNo() {
        return specNo;
    }

    public void setSpecNo(String specNo) {
        this.specNo = specNo;
    }

    public Double getUnitIntegral() {
        return unitIntegral;
    }

    public void setUnitIntegral(Double unitIntegral) {
        this.unitIntegral = unitIntegral;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodsName) {
        this.goodName = goodsName;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Double realPrice) {
        this.realPrice = realPrice;
    }

    public Double getIntegral() {
        return integral;
    }

    public void setIntegral(Double integral) {
        this.integral = integral;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    public OrderActivityBo getPlatform() {
        return platform;
    }

    public void setPlatform(OrderActivityBo platform) {
        this.platform = platform;
    }

    public OrderActivityBo getCoupon() {
        return coupon;
    }

    public void setCoupon(OrderActivityBo coupon) {
        this.coupon = coupon;
    }

    public OrderActivityBo getSpecialActivity() {
        return specialActivity;
    }

    public void setSpecialActivity(OrderActivityBo specialActivity) {
        this.specialActivity = specialActivity;
    }

    public Double getUnitBasePrice() {
        return unitBasePrice;
    }

    public void setUnitBasePrice(Double unitBasePrice) {
        this.unitBasePrice = unitBasePrice;
    }

    public CommodityBo getRelationGood() {
        return relationGood;
    }

    public void setRelationGood(CommodityBo relationGood) {
        this.relationGood = relationGood;
    }

    public OrderVirtualCoinBo getVirtualCoin() {
        return virtualCoin;
    }

    public void setVirtualCoin(OrderVirtualCoinBo virtualCoin) {
        this.virtualCoin = virtualCoin;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getCommodityAmount() {
        return commodityAmount;
    }

    public void setCommodityAmount(String commodityAmount) {
        this.commodityAmount = commodityAmount;
    }

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    @Override
    public String toString() {
        return "ChildOrderBo{" +
                "goodName='" + goodName + '\'' +
                ", unitPrice=" + unitPrice +
                ", realPrice=" + realPrice +
                ", unitIntegral=" + unitIntegral +
                ", integral=" + integral +
                ", unitBasePrice=" + unitBasePrice +
                ", basePrice=" + basePrice +
                ", num=" + num +
                ", specName='" + specName + '\'' +
                ", goodId=" + goodId +
                ", goodNo='" + goodNo + '\'' +
                ", specId=" + specId +
                ", specNo='" + specNo + '\'' +
                ", store='" + store + '\'' +
                ", platform=" + platform +
                ", coupon=" + coupon +
                ", specialActivity=" + specialActivity +
                ", virtualCoin=" + virtualCoin +
                ", relationGood=" + relationGood +
                ", commodityAmount='" + commodityAmount + '\'' +
                "} " + super.toString();
    }
}
