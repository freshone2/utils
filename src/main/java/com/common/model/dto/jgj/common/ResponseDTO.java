package com.common.model.dto.jgj.common;

import lombok.Data;

/**
 * Created by wangwei on 2018/8/14.
 */
@Data
public class ResponseDTO<T> {

    private String ret;

    private String msg;

    private String requestId;

    private T data;

}
