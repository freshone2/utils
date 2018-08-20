package com.common.model.dto.jgj.coupon;

import com.common.model.dto.jgj.common.RequestDTO;
import lombok.Data;

import java.util.List;

/**
 * Created by wangwei on 2018/8/14.
 */
@Data
public class UsableCouponRequestDTO extends RequestDTO {

    private String orderAmount;

    private String cv;

    private List<OrderInfoDTO> orderInfo;
}
