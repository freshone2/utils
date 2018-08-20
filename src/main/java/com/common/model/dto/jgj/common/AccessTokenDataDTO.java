package com.common.model.dto.jgj.common;

import lombok.Data;

/**
 * Created by wangwei on 2018/8/14.
 */
@Data
public class AccessTokenDataDTO {

    private String expires_in;

    private String openid;

    private String access_token;

}
