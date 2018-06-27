package com.common.model.dto.pay;

public class PayMessageDTO {
    private String userId;
    private String password;
    private String orderId;
    /*单据类型*/
    private String processType;
    /*产品编码*/
    private String orderedProd;

    private Integer quantity;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getProcessType() {
        return processType;
    }

    public void setProcessType(String processType) {
        this.processType = processType;
    }

    public String getOrderedProd() {
        return orderedProd;
    }

    public void setOrderedProd(String orderedProd) {
        this.orderedProd = orderedProd;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "PayMessageDTO{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", orderId='" + orderId + '\'' +
                ", processType='" + processType + '\'' +
                ", orderedProd='" + orderedProd + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
