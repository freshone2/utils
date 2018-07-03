package com.common.model.bo.config;

import java.util.HashMap;

/**
 * @Package: com.common.model.bo.config
 * @Description:
 * @author: jklofs
 * @date: 2018/7/3 下午4:44
 */
public class RedisAppConfigBo {
    private boolean huaMeiJiaRegistrationIcon;

    public boolean isHuaMeiJiaRegistrationIcon() {
        return huaMeiJiaRegistrationIcon;
    }

    public void setHuaMeiJiaRegistrationIcon(boolean huaMeiJiaRegistrationIcon) {
        this.huaMeiJiaRegistrationIcon = huaMeiJiaRegistrationIcon;
    }

    @Override
    public String toString() {
        return "RedisAppConfigBo{" +
                "huaMeiJiaRegistrationIcon=" + huaMeiJiaRegistrationIcon +
                '}';
    }
}
