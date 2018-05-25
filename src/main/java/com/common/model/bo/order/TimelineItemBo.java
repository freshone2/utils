package com.common.model.bo.order;

/**
 * @Package: pecker.model.bo.order
 * @Description:
 * @author: jklofs
 * @date: 2018/3/30 上午10:04
 */
public class TimelineItemBo {
    private Integer status;
    private Long createdAt;
    private String displayStatus;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public String getDisplayStatus() {
        return displayStatus;
    }

    public void setDisplayStatus(String displayStatus) {
        this.displayStatus = displayStatus;
    }

    @Override
    public String toString() {
        return "TimelineItemBo{" +
                "status=" + status +
                ", createdAt=" + createdAt +
                ", displayStatus='" + displayStatus + '\'' +
                '}';
    }
}
