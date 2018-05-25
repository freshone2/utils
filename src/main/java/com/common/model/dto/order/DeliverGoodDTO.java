package com.common.model.dto.order;

import com.common.model.bo.order.LogisticsBo;

import java.util.List;

/**
 * @Package: pecker.model.dto
 * @Description:
 * @author: jklofs
 * @date: 2018/4/10 下午2:24
 */
public class DeliverGoodDTO {
    private String orderId;
    private List<String> childOrders;
    private LogisticsBo logistics;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<String> getChildOrders() {
        return childOrders;
    }

    public void setChildOrders(List<String> childOrders) {
        this.childOrders = childOrders;
    }

    public LogisticsBo getLogistics() {
        return logistics;
    }

    public void setLogistics(LogisticsBo logistics) {
        this.logistics = logistics;
    }

    @Override
    public String toString() {
        return "DeliverGoodDTO{" +
                "orderId='" + orderId + '\'' +
                ", childOrders=" + childOrders +
                ", logistics=" + logistics +
                '}';
    }
}
