package com.common.model.bo.presale;

import java.util.List;

public class PreSaleActivityContentBo {

    private Integer preSaleId;

    private String title;

    private String appCode;

    private String description;

    private Long effectiveStartAt;

    private Long effectiveEndAt;

    private Long depositEndAt;

    private Long tailStartAt;

    private Integer useCoupon;

    private Long createAt;

    private Integer status;

    private Integer stage;

    private List<PreSaleSpecificationContentBo> preSaleCommodities;

    public Integer getPreSaleId() {
        return preSaleId;
    }

    public void setPreSaleId(Integer preSaleId) {
        this.preSaleId = preSaleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getEffectiveStartAt() {
        return effectiveStartAt;
    }

    public void setEffectiveStartAt(Long effectiveStartAt) {
        this.effectiveStartAt = effectiveStartAt;
    }

    public Long getEffectiveEndAt() {
        return effectiveEndAt;
    }

    public void setEffectiveEndAt(Long effectiveEndAt) {
        this.effectiveEndAt = effectiveEndAt;
    }

    public Long getDepositEndAt() {
        return depositEndAt;
    }

    public void setDepositEndAt(Long depositEndAt) {
        this.depositEndAt = depositEndAt;
    }

    public Long getTailStartAt() {
        return tailStartAt;
    }

    public void setTailStartAt(Long tailStartAt) {
        this.tailStartAt = tailStartAt;
    }

    public Integer getUseCoupon() {
        return useCoupon;
    }

    public void setUseCoupon(Integer useCoupon) {
        this.useCoupon = useCoupon;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public List<PreSaleSpecificationContentBo> getPreSaleCommodities() {
        return preSaleCommodities;
    }

    public void setPreSaleCommodities(List<PreSaleSpecificationContentBo> preSaleCommodities) {
        this.preSaleCommodities = preSaleCommodities;
    }
}
