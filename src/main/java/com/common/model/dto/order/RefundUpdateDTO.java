package com.common.model.dto.order;

import java.util.Map;

/**
 * @Package: pecker.model.dto
 * @Description:
 * @author: jklofs
 * @date: 2018/5/8 上午10:58
 */
public class RefundUpdateDTO {
    private String refundOrderId;
    private Map<String,Object> opts;

    public String getRefundOrderId() {
        return refundOrderId;
    }

    public void setRefundOrderId(String refundOrderId) {
        this.refundOrderId = refundOrderId;
    }

    public Map<String, Object> getOpts() {
        return opts;
    }

    public void setOpts(Map<String, Object> opts) {
        this.opts = opts;
    }

    @Override
    public String toString() {
        return "RefundUpdateDTO{" +
                "refundOrderId='" + refundOrderId + '\'' +
                ", opts=" + opts +
                '}';
    }
}
