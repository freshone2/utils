package com.common.model.bo.commodity;

public class CommoditySpecificationParameterBo {
    private Integer commoditySpecificationParameterId;

    private String commoditySpecificationParameterName;

    private Integer parameterId;

    private Integer commodityId;

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public Integer getCommoditySpecificationParameterId() {
        return commoditySpecificationParameterId;
    }

    public void setCommoditySpecificationParameterId(Integer commoditySpecificationParameterId) {
        this.commoditySpecificationParameterId = commoditySpecificationParameterId;
    }

    public String getCommoditySpecificationParameterName() {
        return commoditySpecificationParameterName;
    }

    public void setCommoditySpecificationParameterName(String commoditySpecificationParameterName) {
        this.commoditySpecificationParameterName = commoditySpecificationParameterName == null ? null : commoditySpecificationParameterName.trim();
    }

    public Integer getParameterId() {
        return parameterId;
    }

    public void setParameterId(Integer parameterId) {
        this.parameterId = parameterId;
    }

    @Override
    public String toString() {
        return "CommoditySpecificationParameterBo{" +
                "commoditySpecificationParameterId=" + commoditySpecificationParameterId +
                ", commoditySpecificationParameterName='" + commoditySpecificationParameterName + '\'' +
                ", parameterId=" + parameterId +
                ", commodityId=" + commodityId +
                '}';
    }
}