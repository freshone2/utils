package com.common.model.dto;

import java.util.List;

public class SpecDTO {
    private String appCode;
    private List<Integer> specIds;

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public List<Integer> getSpecIds() {
        return specIds;
    }

    public void setSpecIds(List<Integer> specIds) {
        this.specIds = specIds;
    }
}
