package com.common.model.bo.presale;

public class PreSaleSpecificationContentBo {

    private Integer preSaleCommodityId;

    private Integer commoditySpecificationId;

    private Double preSalePrice;

    private Double depositMoney;

    private Double depositExpandMoney;

    private Double tailMoney;

    private Integer inventory;

    private Integer buyLimit;

    private Integer preSaleId;

    public Integer getPreSaleCommodityId() {
        return preSaleCommodityId;
    }

    public void setPreSaleCommodityId(Integer preSaleCommodityId) {
        this.preSaleCommodityId = preSaleCommodityId;
    }

    public Integer getCommoditySpecificationId() {
        return commoditySpecificationId;
    }

    public void setCommoditySpecificationId(Integer commoditySpecificationId) {
        this.commoditySpecificationId = commoditySpecificationId;
    }

    public Double getPreSalePrice() {
        return preSalePrice;
    }

    public void setPreSalePrice(Double preSalePrice) {
        this.preSalePrice = preSalePrice;
    }

    public Double getDepositMoney() {
        return depositMoney;
    }

    public void setDepositMoney(Double depositMoney) {
        this.depositMoney = depositMoney;
    }

    public Double getDepositExpandMoney() {
        return depositExpandMoney;
    }

    public void setDepositExpandMoney(Double depositExpandMoney) {
        this.depositExpandMoney = depositExpandMoney;
    }

    public Double getTailMoney() {
        return tailMoney;
    }

    public void setTailMoney(Double tailMoney) {
        this.tailMoney = tailMoney;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getBuyLimit() {
        return buyLimit;
    }

    public void setBuyLimit(Integer buyLimit) {
        this.buyLimit = buyLimit;
    }

    public Integer getPreSaleId() {
        return preSaleId;
    }

    public void setPreSaleId(Integer preSaleId) {
        this.preSaleId = preSaleId;
    }
}
