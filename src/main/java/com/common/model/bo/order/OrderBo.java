package com.common.model.bo.order;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * @Package: pecker.model.bo
 * @Description:
 * @author: jklofs
 * @date: 2018/3/27 下午2:47
 */
public class OrderBo extends BaseOrderBo {

    @Id
    private String _id;
    private String platformCode;
    private String channel;
    private String channelName;
    private String shardKey;
    //用户相关价格
    private Double orderPrice;
    private Double realPrice;
    private Double integral;
    //平台相关价格
    private Double basePrice;
    private String userId;
    private String userPhone;
    private String payChannel;
    private String appCode;
    private InvoiceBo invoice;
    private Double logisticsPrice;
    private String logisticsCode;
    private List<LogisticsBo> logistics;
    private List<ChildOrderBo> goods;
    private ContactBo contact;
    private String paymentSerial;
    private String refundmentSerial;
    private List<String> paidList;
    private List<String> refundSerialNumList;
    private List<SerialNumBo> serialNumList;
    private Integer partialRefund;
    private List<AssociatedOrderBo>  associatedOrders;
    private String sellerRemark;
    private String buyerRemark;
    private Integer canAdjustAmount;
    private Integer orderType;
    private OrderVirtualCoinBo virtualCoin;
    private OrderActivityBo platform;
    private OrderActivityBo coupon;
    private OrderActivityBo specialActivity;
    private int userDeleted = 0;
    private String merchantCode;
    private String agentNo;
    private String commission;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getShardKey() {
        return shardKey;
    }

    public void setShardKey(String shardKey) {
        this.shardKey = shardKey;
    }

    public String getPlatformCode() {
        return platformCode;
    }

    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Double getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Double realPrice) {
        this.realPrice = realPrice;
    }

    public Double getIntegral() {
        return integral;
    }

    public void setIntegral(Double integral) {
        this.integral = integral;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
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

    public String getPayChannel() {
        return payChannel;
    }

    public void setPayChannel(String payChannel) {
        this.payChannel = payChannel;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public InvoiceBo getInvoice() {
        return invoice;
    }

    public void setInvoice(InvoiceBo invoice) {
        this.invoice = invoice;
    }

    public Double getLogisticsPrice() {
        return logisticsPrice;
    }

    public void setLogisticsPrice(Double logisticsPrice) {
        this.logisticsPrice = logisticsPrice;
    }

    public List<LogisticsBo> getLogistics() {
        return logistics;
    }

    public void setLogistics(List<LogisticsBo> logistics) {
        this.logistics = logistics;
    }

    public List<ChildOrderBo> getGoods() {
        return goods;
    }

    public void setGoods(List<ChildOrderBo> goods) {
        this.goods = goods;
    }

    public ContactBo getContact() {
        return contact;
    }

    public void setContact(ContactBo contact) {
        this.contact = contact;
    }

    public String getPaymentSerial() {
        return paymentSerial;
    }

    public void setPaymentSerial(String paymentSerial) {
        this.paymentSerial = paymentSerial;
    }

    public List<String> getPaidList() {
        return paidList;
    }

    public void setPaidList(List<String> paidList) {
        this.paidList = paidList;
    }

    public List<String> getRefundSerialNumList() {
        return refundSerialNumList;
    }

    public void setRefundSerialNumList(List<String> refundSerialNumList) {
        this.refundSerialNumList = refundSerialNumList;
    }

    public List<SerialNumBo> getSerialNumList() {
        return serialNumList;
    }

    public void setSerialNumList(List<SerialNumBo> serialNumList) {
        this.serialNumList = serialNumList;
    }

    public Integer getPartialRefund() {
        return partialRefund;
    }

    public void setPartialRefund(Integer partialRefund) {
        this.partialRefund = partialRefund;
    }

    public List<AssociatedOrderBo> getAssociatedOrders() {
        return associatedOrders;
    }

    public void setAssociatedOrders(List<AssociatedOrderBo> associatedOrders) {
        this.associatedOrders = associatedOrders;
    }

    public String getSellerRemark() {
        return sellerRemark;
    }

    public void setSellerRemark(String sellerRemark) {
        this.sellerRemark = sellerRemark;
    }

    public String getBuyerRemark() {
        return buyerRemark;
    }

    public void setBuyerRemark(String buyerRemark) {
        this.buyerRemark = buyerRemark;
    }

    public Integer getCanAdjustAmount() {
        return canAdjustAmount;
    }

    public void setCanAdjustAmount(Integer canAdjustAmount) {
        this.canAdjustAmount = canAdjustAmount;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public OrderActivityBo getPlatform() {
        return platform;
    }

    public void setPlatform(OrderActivityBo platform) {
        this.platform = platform;
    }

    public OrderActivityBo getCoupon() {
        return coupon;
    }

    public void setCoupon(OrderActivityBo coupon) {
        this.coupon = coupon;
    }

    public OrderActivityBo getSpecialActivity() {
        return specialActivity;
    }

    public void setSpecialActivity(OrderActivityBo specialActivity) {
        this.specialActivity = specialActivity;
    }

    public String getRefundmentSerial() {
        return refundmentSerial;
    }

    public void setRefundmentSerial(String refundmentSerial) {
        this.refundmentSerial = refundmentSerial;
    }

    public OrderVirtualCoinBo getVirtualCoin() {
        return virtualCoin;
    }

    public void setVirtualCoin(OrderVirtualCoinBo virtualCoin) {
        this.virtualCoin = virtualCoin;
    }

    public String getLogisticsCode() {
        return logisticsCode;
    }

    public void setLogisticsCode(String logisticsCode) {
        this.logisticsCode = logisticsCode;
    }

    public int getUserDeleted() {
        return userDeleted;
    }

    public void setUserDeleted(int userDeleted) {
        this.userDeleted = userDeleted;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getAgentNo() {
        return agentNo;
    }

    public void setAgentNo(String agentNo) {
        this.agentNo = agentNo;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    @Override
    public String toString() {
        return "OrderBo{" +
                "_id='" + _id + '\'' +
                ", platformCode='" + platformCode + '\'' +
                ", channel='" + channel + '\'' +
                ", channelName='" + channelName + '\'' +
                ", shardKey='" + shardKey + '\'' +
                ", orderPrice=" + orderPrice +
                ", realPrice=" + realPrice +
                ", integral=" + integral +
                ", basePrice=" + basePrice +
                ", userId='" + userId + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", payChannel='" + payChannel + '\'' +
                ", appCode='" + appCode + '\'' +
                ", invoice=" + invoice +
                ", logisticsPrice=" + logisticsPrice +
                ", logisticsCode='" + logisticsCode + '\'' +
                ", logistics=" + logistics +
                ", goods=" + goods +
                ", contact=" + contact +
                ", paymentSerial='" + paymentSerial + '\'' +
                ", refundmentSerial='" + refundmentSerial + '\'' +
                ", paidList=" + paidList +
                ", refundSerialNumList=" + refundSerialNumList +
                ", serialNumList=" + serialNumList +
                ", partialRefund=" + partialRefund +
                ", associatedOrders=" + associatedOrders +
                ", sellerRemark='" + sellerRemark + '\'' +
                ", buyerRemark='" + buyerRemark + '\'' +
                ", canAdjustAmount=" + canAdjustAmount +
                ", orderType=" + orderType +
                ", virtualCoin=" + virtualCoin +
                ", platform=" + platform +
                ", coupon=" + coupon +
                ", specialActivity=" + specialActivity +
                ", userDeleted=" + userDeleted +
                ", merchantCode='" + merchantCode + '\'' +
                ", agentNo='" + agentNo + '\'' +
                ", commission='" + commission + '\'' +
                "} " + super.toString();
    }
}
