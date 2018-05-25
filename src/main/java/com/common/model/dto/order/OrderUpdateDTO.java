package com.common.model.dto.order;

import java.util.Map;

/**
 * @Package: pecker.model.dto
 * @Description:
 * @author: jklofs
 * @date: 2018/5/3 下午6:54
 */
public class OrderUpdateDTO {
    private String orderId;
    private Map<String,Object> opts;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Map<String, Object> getOpts() {
        return opts;
    }

    public void setOpts(Map<String, Object> opts) {
        this.opts = opts;
    }

    @Override
    public String toString() {
        return "OrderUpdateDTO{" +
                "orderId='" + orderId + '\'' +
                ", opts=" + opts +
                '}';
    }
}
