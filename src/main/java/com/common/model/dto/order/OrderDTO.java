package com.common.model.dto.order;

import com.common.model.bo.order.ChildOrderBo;
import com.common.model.bo.order.ContactBo;
import com.common.model.bo.order.InvoiceBo;

import java.util.List;

/**
 * @Package: pecker.model.dto
 * @Description:
 * @author: jklofs
 * @date: 2018/5/2 下午5:51
 */
public class OrderDTO {
    private String channel;

    private String appCode;

    private Integer orderType;

    private Integer canAdjustAmount;

    private Integer partialRefund;

    private InvoiceBo invoice;

    private List<ChildOrderBo> childOrders;

    private Integer couponId;

    private Integer platformId;

    private String userId;

    private String userPhone;

    private ContactBo contact;

    private String buyerRemark;

    private Double virtualCoin;

    private String logisticsCode;

    private String icon;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLogisticsCode() {
        return logisticsCode;
    }

    public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getCanAdjustAmount() {
        return canAdjustAmount;
    }

    public void setCanAdjustAmount(Integer canAdjustAmount) {
        this.canAdjustAmount = canAdjustAmount;
    }

    public Integer getPartialRefund() {
        return partialRefund;
    }

    public void setPartialRefund(Integer partialRefund) {
        this.partialRefund = partialRefund;
    }

    public InvoiceBo getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceBo invoice) {
        this.invoice = invoice;
    }

    public List<ChildOrderBo> getChildOrders() {
        return childOrders;
    }

    public void setChildOrders(List<ChildOrderBo> childOrders) {
        this.childOrders = childOrders;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Integer getPlatformId() {
        return platformId;
    }

    public void setPlatformId(Integer platformId) {
        this.platformId = platformId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public ContactBo getContact() {
        return contact;
    }

    public void setContact(ContactBo contact) {
        this.contact = contact;
    }

    public String getBuyerRemark() {
        return buyerRemark;
    }

    public void setBuyerRemark(String buyerRemark) {
        this.buyerRemark = buyerRemark;
    }

    public Double getVirtualCoin() {
        return virtualCoin;
    }

    public void setVirtualCoin(Double virtualCoin) {
        this.virtualCoin = virtualCoin;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "channel='" + channel + '\'' +
                ", appCode='" + appCode + '\'' +
                ", orderType=" + orderType +
                ", canAdjustAmount=" + canAdjustAmount +
                ", partialRefund=" + partialRefund +
                ", invoice=" + invoice +
                ", childOrders=" + childOrders +
                ", couponId=" + couponId +
                ", platformId=" + platformId +
                ", userId='" + userId + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", contact=" + contact +
                ", buyerRemark='" + buyerRemark + '\'' +
                ", virtualCoin=" + virtualCoin +
                '}';
    }
}
