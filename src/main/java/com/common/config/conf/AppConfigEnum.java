package com.common.config.conf;

/**
 * @Package: com.common.config.conf
 * @Description:
 * @author: jklofs
 * @date: 2018/7/3 下午4:54
 */
public enum AppConfigEnum {
    HUA_MEI_JIA_REGISTRATION_ICON("huaMeiJiaRegistrationIcon"),
    HUA_MEI_JIA_REGISTRATION_URL("huaMeiJiaRegistrationUrl"),
    HUA_MEI_JIA_REGISTRATION_VIEW("huaMeiJiaRegistrationView");

    public final String CODE;

    AppConfigEnum(String CODE) {
        this.CODE = CODE;
    }
}
