package com.common.model.dto.jgj.coupon;

import com.common.model.dto.jgj.common.RequestDTO;
import lombok.Data;

import java.util.List;

/**
 * Created by wangwei on 2018/8/15.
 */
@Data
public class LockCouponRequestDTO extends RequestDTO {

    private String orderAmount;

    private List<OrderInfoDTO> orderInfo;

    private String discountAmount;

    private List<String> couponIdList;

}
