package com.common.model.bo.commodity;

public class CommodityLabelBo {
    private Integer commodityLabelId;

    private Integer commodityId;

    private Integer labelId;

    private String labelName;

    public Integer getCommodityLabelId() {
        return commodityLabelId;
    }

    public void setCommodityLabelId(Integer commodityLabelId) {
        this.commodityLabelId = commodityLabelId;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public Integer getLabelId() {
        return labelId;
    }

    public void setLabelId(Integer labelId) {
        this.labelId = labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }
}