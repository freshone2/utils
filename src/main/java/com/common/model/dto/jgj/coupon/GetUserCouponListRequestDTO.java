package com.common.model.dto.jgj.coupon;

import com.common.model.dto.jgj.common.RequestDTO;
import lombok.Data;

/**
 * Created by wangwei on 2018/8/27.
 */
@Data
public class GetUserCouponListRequestDTO extends RequestDTO{

    private String mobilePhone;

    private String pageSize;

    private String pageIndex;

    private String couponsStatus;

}
