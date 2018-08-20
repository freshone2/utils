package com.common.model.dto.jgj.common;

import lombok.Data;

/**
 * Created by wangwei on 2018/8/14.
 */
@Data
public class RequestDTO {

    private String access_token;

    private String requestId;

    private String openId;

    private String merchantCode;

    private String sign;

}
