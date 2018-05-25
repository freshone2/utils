package com.common.model.dto.commodity;

/**
 * Created by wangwei on 2018/5/9.
 */
public class CommodityInfoDTO {
    /*产品编号*/
    private String skuSn;

    /*产品名称*/
    private String skuName;

    /*
    产品属性编号（物料组编号），用来区分产品、服务、消费卡
    应该是sku类型吧
    */
    private String skuTypeSn;

    /*
    产品属性名称
    产品属性编号描述
    这说的是什么？？？没懂
    */
    private String skuTypeName;

    /*品牌编码，不是店铺，是品牌！！！*/
    private String brandSn;

    /*品牌编码名称*/
    private String brandName;

    /*产品分类编码1*/
    private String categorySn;

    /*产品分类（产品分类的最后一层），目前放系列*/
    private String seriesSn;

    /*包装规格*/
    private String packingSpecifications;

    /*包装单位编码*/
    private String packingUnitSn;

    /*包装单位名称*/
    private String packingUnit;

    /*基本单位编码*/
    private String baseUnitSn;

    /*基本单位名称*/
    private String baseUnit;

    /*商品条形码*/
    private String barCode;

    /*保质期*/
    private String shelfLife;

    /*销售状态*/
    private Integer status;

    /*公司代码*/
    private String enterpriseSn;

    /*是否扫描*/
    private String zscan;

    /*物料类型*/
    private String materialType;

    /*毛重*/
    private String grossWeight;

    /*净重*/
    private String netWeight;

    /*单位*/
    private String Unit;

    /*sap价*/
    private Double sapPrice;

    public String getSkuSn() {
        return skuSn;
    }

    public void setSkuSn(String skuSn) {
        this.skuSn = skuSn;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getSkuTypeSn() {
        return skuTypeSn;
    }

    public void setSkuTypeSn(String skuTypeSn) {
        this.skuTypeSn = skuTypeSn;
    }

    public String getSkuTypeName() {
        return skuTypeName;
    }

    public void setSkuTypeName(String skuTypeName) {
        this.skuTypeName = skuTypeName;
    }

    public String getBrandSn() {
        return brandSn;
    }

    public void setBrandSn(String brandSn) {
        this.brandSn = brandSn;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCategorySn() {
        return categorySn;
    }

    public void setCategorySn(String categorySn) {
        this.categorySn = categorySn;
    }

    public String getSeriesSn() {
        return seriesSn;
    }

    public void setSeriesSn(String seriesSn) {
        this.seriesSn = seriesSn;
    }

    public String getPackingSpecifications() {
        return packingSpecifications;
    }

    public void setPackingSpecifications(String packingSpecifications) {
        this.packingSpecifications = packingSpecifications;
    }

    public String getPackingUnitSn() {
        return packingUnitSn;
    }

    public void setPackingUnitSn(String packingUnitSn) {
        this.packingUnitSn = packingUnitSn;
    }

    public String getPackingUnit() {
        return packingUnit;
    }

    public void setPackingUnit(String packingUnit) {
        this.packingUnit = packingUnit;
    }

    public String getBaseUnitSn() {
        return baseUnitSn;
    }

    public void setBaseUnitSn(String baseUnitSn) {
        this.baseUnitSn = baseUnitSn;
    }

    public String getBaseUnit() {
        return baseUnit;
    }

    public void setBaseUnit(String baseUnit) {
        this.baseUnit = baseUnit;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEnterpriseSn() {
        return enterpriseSn;
    }

    public void setEnterpriseSn(String enterpriseSn) {
        this.enterpriseSn = enterpriseSn;
    }

    public String getZscan() {
        return zscan;
    }

    public void setZscan(String zscan) {
        this.zscan = zscan;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getGrossWeight() {
        return grossWeight;
    }

    public void setGrossWeight(String grossWeight) {
        this.grossWeight = grossWeight;
    }

    public String getNetWeight() {
        return netWeight;
    }

    public void setNetWeight(String netWeight) {
        this.netWeight = netWeight;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public Double getSapPrice() {
        return sapPrice;
    }

    public void setSapPrice(Double sapPrice) {
        this.sapPrice = sapPrice;
    }

    @Override
    public String toString() {
        return "CommodityInfoDTO{" +
                "skuSn='" + skuSn + '\'' +
                ", skuName='" + skuName + '\'' +
                ", skuTypeSn='" + skuTypeSn + '\'' +
                ", skuTypeName='" + skuTypeName + '\'' +
                ", brandSn='" + brandSn + '\'' +
                ", brandName='" + brandName + '\'' +
                ", categorySn='" + categorySn + '\'' +
                ", seriesSn='" + seriesSn + '\'' +
                ", packingSpecifications='" + packingSpecifications + '\'' +
                ", packingUnitSn='" + packingUnitSn + '\'' +
                ", packingUnit='" + packingUnit + '\'' +
                ", baseUnitSn='" + baseUnitSn + '\'' +
                ", baseUnit='" + baseUnit + '\'' +
                ", barCode='" + barCode + '\'' +
                ", shelfLife='" + shelfLife + '\'' +
                ", status=" + status +
                ", enterpriseSn='" + enterpriseSn + '\'' +
                ", zscan='" + zscan + '\'' +
                ", materialType='" + materialType + '\'' +
                ", grossWeight='" + grossWeight + '\'' +
                ", netWeight='" + netWeight + '\'' +
                ", Unit='" + Unit + '\'' +
                ", sapPrice=" + sapPrice +
                '}';
    }
}
