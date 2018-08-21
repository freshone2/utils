package com.common.model.dto.jgj.coupon;

import com.common.model.dto.jgj.common.RequestDTO;
import lombok.Data;

/**
 * Created by wangwei on 2018/8/20.
 */
@Data
public class HaveAvailableCouponsRequestDTO extends RequestDTO {

    private HaveAvailableCouponsQueryParamsDTO queryParams;

}
