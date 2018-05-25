package com.common.model.bo.order;

/**
 * @Package: com.common.model.bo.order
 * @Description:
 * @author: jklofs
 * @date: 2018/5/7 下午8:57
 */
public class RelationGoodBo {
    private String goodName;
    //用户相关价格
    private Double unitPrice;
    private Double realPrice;
    private Double unitIntegral;
    private String specName;
    private Integer goodId;
    private String goodNo;
    private Integer specId;
    private String specNo;

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
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

    public Double getUnitIntegral() {
        return unitIntegral;
    }

    public void setUnitIntegral(Double unitIntegral) {
        this.unitIntegral = unitIntegral;
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

    public String getGoodNo() {
        return goodNo;
    }

    public void setGoodNo(String goodNo) {
        this.goodNo = goodNo;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    public String getSpecNo() {
        return specNo;
    }

    public void setSpecNo(String specNo) {
        this.specNo = specNo;
    }

    @Override
    public String toString() {
        return "RelationGoodBo{" +
                "goodName='" + goodName + '\'' +
                ", unitPrice=" + unitPrice +
                ", realPrice=" + realPrice +
                ", unitIntegral=" + unitIntegral +
                ", specName='" + specName + '\'' +
                ", goodId=" + goodId +
                ", goodNo='" + goodNo + '\'' +
                ", specId=" + specId +
                ", specNo='" + specNo + '\'' +
                '}';
    }
}
