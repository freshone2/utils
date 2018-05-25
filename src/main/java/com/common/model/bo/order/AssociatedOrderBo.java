package com.common.model.bo.order;

/**
 * @Package: pecker.model.bo.order
 * @Description:
 * @author: jklofs
 * @date: 2018/3/30 上午10:04
 */
public class AssociatedOrderBo {
    private String id;
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "AssociatedOrderBo{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
