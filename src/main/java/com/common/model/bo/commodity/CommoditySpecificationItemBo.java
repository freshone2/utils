package com.common.model.bo.commodity;

public class CommoditySpecificationItemBo {
    private Integer commoditySpecificationItemId;

    private Integer parameterId;

    private String specificationParameterName;

    private Integer packageId;

    private String packageName;

    private Integer commoditySpecificationId;

    public Integer getCommoditySpecificationItemId() {
        return commoditySpecificationItemId;
    }

    public void setCommoditySpecificationItemId(Integer commoditySpecificationItemId) {
        this.commoditySpecificationItemId = commoditySpecificationItemId;
    }

    public Integer getParameterId() {
        return parameterId;
    }

    public void setParameterId(Integer parameterId) {
        this.parameterId = parameterId;
    }

    public Integer getCommoditySpecificationId() {
        return commoditySpecificationId;
    }

    public void setCommoditySpecificationId(Integer commoditySpecificationId) {
        this.commoditySpecificationId = commoditySpecificationId;
    }

    public String getSpecificationParameterName() {
        return specificationParameterName;
    }

    public void setSpecificationParameterName(String specificationParameterName) {
        this.specificationParameterName = specificationParameterName;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public String toString() {
        return "CommoditySpecificationItemBo{" +
                "commoditySpecificationItemId=" + commoditySpecificationItemId +
                ", parameterId=" + parameterId +
                ", specificationParameterName='" + specificationParameterName + '\'' +
                ", packageId=" + packageId +
                ", packageName='" + packageName + '\'' +
                ", commoditySpecificationId=" + commoditySpecificationId +
                '}';
    }
}