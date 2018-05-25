package com.common.model.dto.promotion;

import com.common.model.bo.virtualcoin.TimeSharingItem;

import java.util.List;

/**
 * @Package: pecker.model.dto
 * @Description:
 * @author: jklofs
 * @date: 2018/5/19 下午2:52
 */
public class RestorationCoinDTO {
    private String userId;

    private String appCode;

    private List<TimeSharingItem> sharingItemList;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public List<TimeSharingItem> getSharingItemList() {
        return sharingItemList;
    }

    public void setSharingItemList(List<TimeSharingItem> sharingItemList) {
        this.sharingItemList = sharingItemList;
    }

    @Override
    public String toString() {
        return "RestorationCoinDTO{" +
                "userId='" + userId + '\'' +
                ", appCode='" + appCode + '\'' +
                ", sharingItemList=" + sharingItemList +
                '}';
    }
}
