package com.common.model.dto.order;

import com.common.model.bo.order.OrderStatusBo;

import java.util.List;
import java.util.Map;

/**
 * @Package: pecker.model.dto
 * @Description:
 * @author: jklofs
 * @date: 2018/3/30 下午3:38
 */
public class StatusRequestDTO {
    private String id;
    private List<OrderStatusBo> statuses;
    private Map<String,Object> opts;
    private List<String> childOrderIds;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<OrderStatusBo> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<OrderStatusBo> statuses) {
        this.statuses = statuses;
    }

    public Map<String, Object> getOpts() {
        return opts;
    }

    public void setOpts(Map<String, Object> opts) {
        this.opts = opts;
    }

    public List<String> getChildOrderIds() {
        return childOrderIds;
    }

    public void setChildOrderIds(List<String> childOrderIds) {
        this.childOrderIds = childOrderIds;
    }

    @Override
    public String toString() {
        return "StatusRequestDTO{" +
                "id='" + id + '\'' +
                ", statuses=" + statuses +
                ", opts=" + opts +
                ", childOrderIds=" + childOrderIds +
                '}';
    }
}
