package com.common.model.bo.buygift;

import com.common.model.bo.commodity.CommodityBo;

import java.util.List;

/**
 * @Package: com.common.model.bo.buygift
 * @Description:
 * @author: jklofs
 * @date: 2018/7/11 下午4:57
 */
public class BuyGiftActivityContentBo {
    private Integer id;
    private String title;
    private Long effectiveStartAt;
    private Long effectiveEndAt;
    private Integer maxPurchased;
    private String appCode;
    private Long expire;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Integer getMaxPurchased() {
        return maxPurchased;
    }

    public void setMaxPurchased(Integer maxPurchased) {
        this.maxPurchased = maxPurchased;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public Long getExpire() {
        return expire;
    }

    public void setExpire(Long expire) {
        this.expire = expire;
    }

    @Override
    public String toString() {
        return "BuyGiftActivityContentBo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", effectiveStartAt=" + effectiveStartAt +
                ", effectiveEndAt=" + effectiveEndAt +
                ", maxPurchased=" + maxPurchased +
                ", appCode='" + appCode + '\'' +
                ", expire=" + expire +
                '}';
    }
}
