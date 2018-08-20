package com.common.model.dto.jgj.common;

import lombok.Data;

/**
 * Created by wangwei on 2018/8/15.
 */
@Data
public class ResponseDataDTO<T> {

    private String CODE;

    private String MSG;

    private T DATA;

}
