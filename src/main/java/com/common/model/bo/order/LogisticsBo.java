package com.common.model.bo.order;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * @Package: pecker.model.bo.order
 * @Description:
 * @author: jklofs
 * @date: 2018/3/30 上午10:02
 */
public class LogisticsBo {
    public static class LogisticsItemBo{
        private String context;
        private String time;

        public String getContext() {
            return context;
        }

        public void setContext(String context) {
            this.context = context;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "LogisticsItemBo{" +
                    "context='" + context + '\'' +
                    ", time='" + time + '\'' +
                    '}';
        }
    }

    @Field("id")
    private String id;
    private String name;
    private String code;
    private List<String> orderIds;
    private List<LogisticsItemBo> timeline;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<LogisticsItemBo> getTimeline() {
        return timeline;
    }

    public void setTimeline(List<LogisticsItemBo> timeline) {
        this.timeline = timeline;
    }

    public List<String> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<String> orderIds) {
        this.orderIds = orderIds;
    }

    @Override
    public String toString() {
        return "LogisticsBo{" +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", orderIds=" + orderIds +
                ", timeline=" + timeline +
                '}';
    }
}
