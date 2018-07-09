package com.common.model.bo.commodity;

public class SortBo {
    private Integer sortId;

    private String sortName;

    private Integer parentSortId;

    private Integer applicationId;

    private Integer isDisappear;

    private String serial;

    private Long createdAt;

    private Integer commodityCount;

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName == null ? null : sortName.trim();
    }

    public Integer getParentSortId() {
        return parentSortId;
    }

    public void setParentSortId(Integer parentSortId) {
        this.parentSortId = parentSortId;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getIsDisappear() {
        return isDisappear;
    }

    public void setIsDisappear(Integer isDisappear) {
        this.isDisappear = isDisappear;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial == null ? null : serial.trim();
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getCommodityCount() {
        return commodityCount;
    }

    public void setCommodityCount(Integer commodityCount) {
        this.commodityCount = commodityCount;
    }

    @Override
    public String toString() {
        return "SortBo{" +
                "sortId=" + sortId +
                ", sortName='" + sortName + '\'' +
                ", parentSortId=" + parentSortId +
                ", applicationId=" + applicationId +
                ", isDisappear=" + isDisappear +
                ", serial='" + serial + '\'' +
                ", createdAt=" + createdAt +
                ", commodityCount=" + commodityCount +
                '}';
    }
}