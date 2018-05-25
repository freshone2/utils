package com.common.model.bo.order;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Package: pecker.model.bo
 * @Description:
 * @author: jklofs
 * @date: 2018/3/30 上午11:52
 */
public abstract class BaseOrderBo {
    @Field("id")
    protected String id;
    protected Long createdAt;
    protected Integer status;
    protected String displayStatus;
    protected Double adjustAmount;
    protected List<TimelineItemBo> timeline;
    protected String icon;
    protected Integer refundNum;
    protected Map<String,Object> enlarge;

    public Integer getRefundNum() {
        return refundNum;
    }

    public void setRefundNum(Integer refundNum) {
        this.refundNum = refundNum;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
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

    public Double getAdjustAmount() {
        return adjustAmount;
    }

    public void setAdjustAmount(Double adjustAmount) {
        this.adjustAmount = adjustAmount;
    }

    public List<TimelineItemBo> getTimeline() {
        return timeline;
    }

    public void setTimeline(List<TimelineItemBo> timeline) {
        this.timeline = timeline;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Map<String, Object> getEnlarge() {
        return enlarge;
    }

    public void setEnlarge(Map<String, Object> enlarge) {
        this.enlarge = enlarge;
    }

    @Override
    public String toString() {
        return "BaseOrderBo{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", status=" + status +
                ", displayStatus='" + displayStatus + '\'' +
                ", adjustAmount=" + adjustAmount +
                ", timeline=" + timeline +
                ", icon='" + icon + '\'' +
                ", refundNum=" + refundNum +
                '}';
    }
}
