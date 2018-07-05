package com.common.model.bo.config;

import java.util.HashMap;

/**
 * @Package: com.common.model.bo.config
 * @Description:
 * @author: jklofs
 * @date: 2018/7/3 下午4:44
 */
public class RedisAppConfigBo {
    private Boolean huaMeiJiaRegistrationView;
    private String huaMeiJiaRegistrationIcon;
    private String huaMeiJiaRegistrationUrl;

    public Boolean getHuaMeiJiaRegistrationView() {
        return huaMeiJiaRegistrationView;
    }

    public void setHuaMeiJiaRegistrationView(Boolean huaMeiJiaRegistrationView) {
        this.huaMeiJiaRegistrationView = huaMeiJiaRegistrationView;
    }

    public String getHuaMeiJiaRegistrationIcon() {
        return huaMeiJiaRegistrationIcon;
    }

    public void setHuaMeiJiaRegistrationIcon(String huaMeiJiaRegistrationIcon) {
        this.huaMeiJiaRegistrationIcon = huaMeiJiaRegistrationIcon;
    }

    public String getHuaMeiJiaRegistrationUrl() {
        return huaMeiJiaRegistrationUrl;
    }

    public void setHuaMeiJiaRegistrationUrl(String huaMeiJiaRegistrationUrl) {
        this.huaMeiJiaRegistrationUrl = huaMeiJiaRegistrationUrl;
    }

    @Override
    public String toString() {
        return "RedisAppConfigBo{" +
                "huaMeiJiaRegistrationView=" + huaMeiJiaRegistrationView +
                ", huaMeiJiaRegistrationIcon='" + huaMeiJiaRegistrationIcon + '\'' +
                ", huaMeiJiaRegistrationUrl='" + huaMeiJiaRegistrationUrl + '\'' +
                '}';
    }
}
