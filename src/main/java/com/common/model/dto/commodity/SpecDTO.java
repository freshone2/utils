package com.common.model.dto.commodity;

import com.common.model.dto.activity.CartResponseVo;

import java.util.List;

public class SpecDTO {
    private String appCode;
    private List<CartResponseVo> specs;

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public List<CartResponseVo> getSpecs() {
        return specs;
    }

    public void setSpecs(List<CartResponseVo> specs) {
        this.specs = specs;
    }
}
