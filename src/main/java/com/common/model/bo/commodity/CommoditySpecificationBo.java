package com.common.model.bo.commodity;

public class CommoditySpecificationBo {
    private Integer commoditySpecificationId;

    private Double sellingPrice;

    private Double originalPrice;

    private Integer inventory;

    private Integer threshold;

    private Double commodityWeight;

    private Integer commodityId;

    private Double basePrice;

    private String commoditySpecificationNo;

    private String stockNo;

    public Integer getCommoditySpecificationId() {
        return commoditySpecificationId;
    }

    public void setCommoditySpecificationId(Integer commoditySpecificationId) {
        this.commoditySpecificationId = commoditySpecificationId;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    public Double getCommodityWeight() {
        return commodityWeight;
    }

    public void setCommodityWeight(Double commodityWeight) {
        this.commodityWeight = commodityWeight;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public String getCommoditySpecificationNo() {
        return commoditySpecificationNo;
    }

    public void setCommoditySpecificationNo(String commoditySpecificationNo) {
        this.commoditySpecificationNo = commoditySpecificationNo == null ? null : commoditySpecificationNo.trim();
    }

    public String getStockNo() {
        return stockNo;
    }

    public void setStockNo(String stockNo) {
        this.stockNo = stockNo;
    }
}