package com.common.model.bo.commodity;

public class CommodityDetailBo {
    private Integer commodityDetailId;

    private Integer commodityId;

    private String wordDescription;

    private String imgDescription;

    private Integer commodityDetailType;

    private Integer commoditySerial;

    public Integer getCommodityDetailId() {
        return commodityDetailId;
    }

    public void setCommodityDetailId(Integer commodityDetailId) {
        this.commodityDetailId = commodityDetailId;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public String getWordDescription() {
        return wordDescription;
    }

    public void setWordDescription(String wordDescription) {
        this.wordDescription = wordDescription == null ? null : wordDescription.trim();
    }

    public String getImgDescription() {
        return imgDescription;
    }

    public void setImgDescription(String imgDescription) {
        this.imgDescription = imgDescription == null ? null : imgDescription.trim();
    }

    public Integer getCommodityDetailType() {
        return commodityDetailType;
    }

    public void setCommodityDetailType(Integer commodityDetailType) {
        this.commodityDetailType = commodityDetailType;
    }

    public Integer getCommoditySerial() {
        return commoditySerial;
    }

    public void setCommoditySerial(Integer commoditySerial) {
        this.commoditySerial = commoditySerial;
    }
}