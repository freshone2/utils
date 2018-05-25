package com.common.model.bo.order;

import com.common.model.bo.virtualcoin.TimeSharingItem;

import java.util.List;

/**
 * @Package: com.common.model.bo.order
 * @Description:
 * @author: jklofs
 * @date: 2018/5/19 下午12:11
 */
public class OrderVirtualCoinBo {
    private Double price;
    private List<TimeSharingItem> timeSharing;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<TimeSharingItem> getTimeSharing() {
        return timeSharing;
    }

    public void setTimeSharing(List<TimeSharingItem> timeSharing) {
        this.timeSharing = timeSharing;
    }

    @Override
    public String toString() {
        return "OrderVirtualCoinBo{" +
                "price=" + price +
                ", timeSharing=" + timeSharing +
                '}';
    }
}
