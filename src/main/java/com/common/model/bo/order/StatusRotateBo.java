package com.common.model.bo.order;


import com.common.config.conf.OrderStatusEnum;

import java.util.List;

/**
 * @Package: pecker.model.bo
 * @Description:
 * @author: jklofs
 * @date: 2018/4/8 上午9:35
 */
public class StatusRotateBo {
    private List<Integer> choiceList;
    private OrderStatusEnum statusEnum;

    public List<Integer> getChoiceList() {
        return choiceList;
    }

    public void setChoiceList(List<Integer> choiceList) {
        this.choiceList = choiceList;
    }

    public OrderStatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(OrderStatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }

    @Override
    public String toString() {
        return "StatusRotateBo{" +
                "choiceList=" + choiceList +
                ", statusEnum=" + statusEnum +
                '}';
    }
}
