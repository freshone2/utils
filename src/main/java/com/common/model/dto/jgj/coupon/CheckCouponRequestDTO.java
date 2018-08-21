package com.common.model.dto.jgj.coupon;

import com.common.model.dto.jgj.common.RequestDTO;
import lombok.Data;

import java.util.List;

/**
 * Created by wangwei on 2018/8/15.
 */
@Data
public class CheckCouponRequestDTO extends RequestDTO {

    //消费状态 01支付成功 02交易关闭/取消订单
    private String spendingType;

    private List<String> couponIdList;

}
