package com.common.model.bo.order;

/**
 * @Package: pecker.model.bo.order
 * @Description:
 * @author: jklofs
 * @date: 2018/3/30 上午10:01
 */
public class OrderActivityBo {
    private Integer id;
    private Integer couponId;
    private String activityTitle;
    private Double price;

    public OrderActivityBo() {
    }

    public OrderActivityBo(String activityTitle, Double price) {
        this.activityTitle = activityTitle;
        this.price = price;
    }

    public OrderActivityBo(int id, String activityTitle, Double price) {
        this.id = id;
        this.activityTitle = activityTitle;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderActivityBo{" +
                "id=" + id +
                ", couponId=" + couponId +
                ", activityTitle='" + activityTitle + '\'' +
                ", price=" + price +
                '}';
    }
}
