package com.common.model.bo.config;

import java.util.HashMap;

/**
 * @Package: com.common.model.bo.config
 * @Description:
 * @author: jklofs
 * @date: 2018/7/3 下午4:44
 */
public class RedisAppConfigBo {
    private Boolean huaMeiJiaRegistrationIcon;

    public Boolean getHuaMeiJiaRegistrationIcon() {
        return huaMeiJiaRegistrationIcon;
    }

    public void setHuaMeiJiaRegistrationIcon(Boolean huaMeiJiaRegistrationIcon) {
        this.huaMeiJiaRegistrationIcon = huaMeiJiaRegistrationIcon;
    }

    @Override
    public String toString() {
        return "RedisAppConfigBo{" +
                "huaMeiJiaRegistrationIcon=" + huaMeiJiaRegistrationIcon +
                '}';
    }
}
