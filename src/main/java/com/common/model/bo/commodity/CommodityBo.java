package com.common.model.bo.commodity;

import java.util.List;

public class CommodityBo {
    private Integer commodityId;

    private String commodityName;

    private String commodityDescription;

    private Integer commodityCategoryId;

    private Integer specificationsMore;

    private Integer canCheckNum;

    private Integer commodityBrandId;

    private String commodityBrandName;

    private Integer commodityType;

    private Integer canInvoice;

    private Integer commodityCityId;

    private Integer commodityFreightType;

    private Integer returnGoodsType;

    private Integer subType;

    private Long subTime;

    private Long createdAt;

    private Integer purchasesCount;

    private Integer commodityProvinceId;

    private String commodityNo;

    private Boolean clientShow;

    private Long termValidityFrom;

    private Long termValidityTo;

    private Boolean combined;

    private Boolean cancel;

    private Integer status;

    private String rejectReason;

    private String searchKey;

    private String suspendedHints;

    private Integer seriesId;

    private Integer purchasingPlaceType;

    private Integer purchasingPlaceId;

    private Boolean bursting;

    private Boolean addibleShoppingCart;

    private String stockNo;

    private SeriesBo series;

    private Integer currencyType;

    private Integer prepack;

    private String prepackCode;

    private Integer prepackNum;

    private Double commissionRate;

    private Integer deliveryMethod;

    private List<RelationCommodityBo> commoditys;

    private List<CommodityDetailBo> commodityDetails;

    private List<CommodityImgBo> commodityImgs;

    private List<CommoditySpecificationBo> commoditySpecifications;

    private List<SortBo> sorts;

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName == null ? null : commodityName.trim();
    }

    public String getCommodityDescription() {
        return commodityDescription;
    }

    public void setCommodityDescription(String commodityDescription) {
        this.commodityDescription = commodityDescription == null ? null : commodityDescription.trim();
    }

    public Integer getCommodityCategoryId() {
        return commodityCategoryId;
    }

    public void setCommodityCategoryId(Integer commodityCategoryId) {
        this.commodityCategoryId = commodityCategoryId;
    }

    public Integer getSpecificationsMore() {
        return specificationsMore;
    }

    public void setSpecificationsMore(Integer specificationsMore) {
        this.specificationsMore = specificationsMore;
    }

    public Integer getCanCheckNum() {
        return canCheckNum;
    }

    public void setCanCheckNum(Integer canCheckNum) {
        this.canCheckNum = canCheckNum;
    }

    public Integer getCommodityBrandId() {
        return commodityBrandId;
    }

    public void setCommodityBrandId(Integer commodityBrandId) {
        this.commodityBrandId = commodityBrandId;
    }

    public String getCommodityBrandName() {
        return commodityBrandName;
    }

    public void setCommodityBrandName(String commodityBrandName) {
        this.commodityBrandName = commodityBrandName == null ? null : commodityBrandName.trim();
    }

    public Integer getCommodityType() {
        return commodityType;
    }

    public void setCommodityType(Integer commodityType) {
        this.commodityType = commodityType;
    }

    public Integer getCanInvoice() {
        return canInvoice;
    }

    public void setCanInvoice(Integer canInvoice) {
        this.canInvoice = canInvoice;
    }

    public Integer getCommodityCityId() {
        return commodityCityId;
    }

    public void setCommodityCityId(Integer commodityCityId) {
        this.commodityCityId = commodityCityId;
    }

    public Integer getCommodityFreightType() {
        return commodityFreightType;
    }

    public void setCommodityFreightType(Integer commodityFreightType) {
        this.commodityFreightType = commodityFreightType;
    }

    public Integer getReturnGoodsType() {
        return returnGoodsType;
    }

    public void setReturnGoodsType(Integer returnGoodsType) {
        this.returnGoodsType = returnGoodsType;
    }

    public Integer getSubType() {
        return subType;
    }

    public void setSubType(Integer subType) {
        this.subType = subType;
    }

    public Long getSubTime() {
        return subTime;
    }

    public void setSubTime(Long subTime) {
        this.subTime = subTime;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getPurchasesCount() {
        return purchasesCount;
    }

    public void setPurchasesCount(Integer purchasesCount) {
        this.purchasesCount = purchasesCount;
    }

    public Integer getCommodityProvinceId() {
        return commodityProvinceId;
    }

    public void setCommodityProvinceId(Integer commodityProvinceId) {
        this.commodityProvinceId = commodityProvinceId;
    }

    public String getCommodityNo() {
        return commodityNo;
    }

    public void setCommodityNo(String commodityNo) {
        this.commodityNo = commodityNo == null ? null : commodityNo.trim();
    }

    public Boolean getClientShow() {
        return clientShow;
    }

    public void setClientShow(Boolean clientShow) {
        this.clientShow = clientShow;
    }

    public Long getTermValidityFrom() {
        return termValidityFrom;
    }

    public void setTermValidityFrom(Long termValidityFrom) {
        this.termValidityFrom = termValidityFrom;
    }

    public Long getTermValidityTo() {
        return termValidityTo;
    }

    public void setTermValidityTo(Long termValidityTo) {
        this.termValidityTo = termValidityTo;
    }

    public Boolean getCombined() {
        return combined;
    }

    public void setCombined(Boolean combined) {
        this.combined = combined;
    }

    public Boolean getCancel() {
        return cancel;
    }

    public void setCancel(Boolean cancel) {
        this.cancel = cancel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason == null ? null : rejectReason.trim();
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey == null ? null : searchKey.trim();
    }

    public String getSuspendedHints() {
        return suspendedHints;
    }

    public void setSuspendedHints(String suspendedHints) {
        this.suspendedHints = suspendedHints == null ? null : suspendedHints.trim();
    }

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    public SeriesBo getSeries() {
        return series;
    }

    public void setSeries(SeriesBo series) {
        this.series = series;
    }

    public List<RelationCommodityBo> getCommoditys() {
        return commoditys;
    }

    public void setCommoditys(List<RelationCommodityBo> commoditys) {
        this.commoditys = commoditys;
    }

    public List<CommodityDetailBo> getCommodityDetails() {
        return commodityDetails;
    }

    public void setCommodityDetails(List<CommodityDetailBo> commodityDetails) {
        this.commodityDetails = commodityDetails;
    }

    public List<CommodityImgBo> getCommodityImgs() {
        return commodityImgs;
    }

    public void setCommodityImgs(List<CommodityImgBo> commodityImgs) {
        this.commodityImgs = commodityImgs;
    }

    public List<CommoditySpecificationBo> getCommoditySpecifications() {
        return commoditySpecifications;
    }

    public void setCommoditySpecifications(List<CommoditySpecificationBo> commoditySpecifications) {
        this.commoditySpecifications = commoditySpecifications;
    }

    public List<SortBo> getSorts() {
        return sorts;
    }

    public void setSorts(List<SortBo> sorts) {
        this.sorts = sorts;
    }

    public String getStockNo() {
        return stockNo;
    }

    public void setStockNo(String stockNo) {
        this.stockNo = stockNo;
    }

    public Integer getPurchasingPlaceId() {
        return purchasingPlaceId;
    }

    public void setPurchasingPlaceId(Integer purchasingPlaceId) {
        this.purchasingPlaceId = purchasingPlaceId;
    }

    public Boolean getBursting() {
        return bursting;
    }

    public void setBursting(Boolean bursting) {
        this.bursting = bursting;
    }

    public Boolean getAddibleShoppingCart() {
        return addibleShoppingCart;
    }

    public void setAddibleShoppingCart(Boolean addibleShoppingCart) {
        this.addibleShoppingCart = addibleShoppingCart;
    }

    public Integer getPurchasingPlaceType() {
        return purchasingPlaceType;
    }

    public void setPurchasingPlaceType(Integer purchasingPlaceType) {
        this.purchasingPlaceType = purchasingPlaceType;
    }

    public Integer getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(Integer currencyType) {
        this.currencyType = currencyType;
    }

    public Integer getPrepack() {
        return prepack;
    }

    public void setPrepack(Integer prepack) {
        this.prepack = prepack;
    }

    public String getPrepackCode() {
        return prepackCode;
    }

    public void setPrepackCode(String prepackCode) {
        this.prepackCode = prepackCode;
    }

    public Integer getPrepackNum() {
        return prepackNum;
    }

    public void setPrepackNum(Integer prepackNum) {
        this.prepackNum = prepackNum;
    }

    public Double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public Integer getDeliveryMethod() {
        return deliveryMethod;
    }

    public void setDeliveryMethod(Integer deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    @Override
    public String toString() {
        return "CommodityBo{" +
                "commodityId=" + commodityId +
                ", commodityName='" + commodityName + '\'' +
                ", commodityDescription='" + commodityDescription + '\'' +
                ", commodityCategoryId=" + commodityCategoryId +
                ", specificationsMore=" + specificationsMore +
                ", canCheckNum=" + canCheckNum +
                ", commodityBrandId=" + commodityBrandId +
                ", commodityBrandName='" + commodityBrandName + '\'' +
                ", commodityType=" + commodityType +
                ", canInvoice=" + canInvoice +
                ", commodityCityId=" + commodityCityId +
                ", commodityFreightType=" + commodityFreightType +
                ", returnGoodsType=" + returnGoodsType +
                ", subType=" + subType +
                ", subTime=" + subTime +
                ", createdAt=" + createdAt +
                ", purchasesCount=" + purchasesCount +
                ", commodityProvinceId=" + commodityProvinceId +
                ", commodityNo='" + commodityNo + '\'' +
                ", clientShow=" + clientShow +
                ", termValidityFrom=" + termValidityFrom +
                ", termValidityTo=" + termValidityTo +
                ", combined=" + combined +
                ", cancel=" + cancel +
                ", status=" + status +
                ", rejectReason='" + rejectReason + '\'' +
                ", searchKey='" + searchKey + '\'' +
                ", suspendedHints='" + suspendedHints + '\'' +
                ", seriesId=" + seriesId +
                ", purchasingPlaceType=" + purchasingPlaceType +
                ", purchasingPlaceId=" + purchasingPlaceId +
                ", bursting=" + bursting +
                ", addibleShoppingCart=" + addibleShoppingCart +
                ", stockNo='" + stockNo + '\'' +
                ", series=" + series +
                ", currencyType=" + currencyType +
                ", prepack=" + prepack +
                ", prepackCode='" + prepackCode + '\'' +
                ", prepackNum=" + prepackNum +
                ", commissionRate=" + commissionRate +
                ", deliveryMethod=" + deliveryMethod +
                ", commoditys=" + commoditys +
                ", commodityDetails=" + commodityDetails +
                ", commodityImgs=" + commodityImgs +
                ", commoditySpecifications=" + commoditySpecifications +
                ", sorts=" + sorts +
                '}';
    }
}