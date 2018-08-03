package com.common.model.bo.stock;

import java.util.Map;

/**
 * @Package: com.common.model.bo.stock
 * @Description:
 * @author: jklofs
 * @date: 2018/7/16 下午4:23
 */
public class AppStockUpsertBo {
    private Integer specId;

    private String appCode;

    private Integer shareStock;

    private Integer platformStock;

    private Map<String ,Integer> exclusiveStockMap;

    private Map<Integer ,Integer> activityStockMap;

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public Integer getShareStock() {
        return shareStock;
    }

    public void setShareStock(Integer shareStock) {
        this.shareStock = shareStock;
    }

    public Integer getPlatformStock() {
        return platformStock;
    }

    public void setPlatformStock(Integer platformStock) {
        this.platformStock = platformStock;
    }

    public Map<String, Integer> getExclusiveStockMap() {
        return exclusiveStockMap;
    }

    public void setExclusiveStockMap(Map<String, Integer> exclusiveStockMap) {
        this.exclusiveStockMap = exclusiveStockMap;
    }

    public Map<Integer, Integer> getActivityStockMap() {
        return activityStockMap;
    }

    public void setActivityStockMap(Map<Integer, Integer> activityStockMap) {
        this.activityStockMap = activityStockMap;
    }

    @Override
    public String toString() {
        return "AppStockBo{" +
                "specId=" + specId +
                ", shareStock=" + shareStock +
                ", platformStock=" + platformStock +
                ", exclusiveStockMap=" + exclusiveStockMap +
                ", activityStockMap=" + activityStockMap +
                '}';
    }
}
