package com.common.model.bo.commodity;

public class CommodityImgBo {
    private Integer commodityImgId;

    private String commodityImgUrl;

    private Integer commodityId;

    public Integer getCommodityImgId() {
        return commodityImgId;
    }

    public void setCommodityImgId(Integer commodityImgId) {
        this.commodityImgId = commodityImgId;
    }

    public String getCommodityImgUrl() {
        return commodityImgUrl;
    }

    public void setCommodityImgUrl(String commodityImgUrl) {
        this.commodityImgUrl = commodityImgUrl == null ? null : commodityImgUrl.trim();
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }
}