package com.common.model.bo.order;

/**
 * @Package: pecker.model.bo
 * @Description:
 * @author: jklofs
 * @date: 2018/4/3 上午10:54
 */
public class OrderStatusBo {
    private Integer status;
    private String displayStatus;

    public OrderStatusBo() {
    }

    public OrderStatusBo(Integer status, String displayStatus) {
        this.status = status;
        this.displayStatus = displayStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderStatusBo statusBo = (OrderStatusBo) o;

        return status != null ? status.equals(statusBo.status) : statusBo.status == null;
    }

    @Override
    public int hashCode() {
        return status != null ? status.hashCode() : 0;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDisplayStatus() {
        return displayStatus;
    }

    public void setDisplayStatus(String displayStatus) {
        this.displayStatus = displayStatus;
    }

    @Override
    public String toString() {
        return "OrderStatusBo{" +
                "status=" + status +
                ", displayStatus='" + displayStatus + '\'' +
                '}';
    }
}
