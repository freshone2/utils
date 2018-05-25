package com.common.model.bo.order;

import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * @Package: pecker.model.bo
 * @Description:
 * @author: jklofs
 * @date: 2018/4/8 下午5:03
 */
public class RefundOrderBo extends BaseOrderBo {

    @Id
    private String _id;

    private Integer orderType;

    private String userId;

    private String shardKey;

    private String originId;

    private Double amount;

    private Double integral;

    private Integer virtualCoin;

    private Double basePrice;

    private String channel;

    private String refundSerialNum;

    private String appCode;

    private List<String> relatedCommodities;

    private List<ChildOrderBo> goods;

    private String reason;

    private Integer auditsNum;

    private Integer refundType;

    private LogisticsBo logistics;

    private List<String> images;

    private String platformCode;

    private String explain;

    private ContactBo buyer;

    private ContactBo seller;

    private String rejectReason;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getShardKey() {
        return shardKey;
    }

    public void setShardKey(String shardKey) {
        this.shardKey = shardKey;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getRefundSerialNum() {
        return refundSerialNum;
    }

    public void setRefundSerialNum(String refundSerialNum) {
        this.refundSerialNum = refundSerialNum;
    }

    public String getAppCode() {
        return appCode;
    }

    public void setAppCode(String appCode) {
        this.appCode = appCode;
    }

    public List<String> getRelatedCommodities() {
        return relatedCommodities;
    }

    public void setRelatedCommodities(List<String> relatedCommodities) {
        this.relatedCommodities = relatedCommodities;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getAuditsNum() {
        return auditsNum;
    }

    public void setAuditsNum(Integer auditsNum) {
        this.auditsNum = auditsNum;
    }

    public Integer getRefundType() {
        return refundType;
    }

    public void setRefundType(Integer refundType) {
        this.refundType = refundType;
    }

    public LogisticsBo getLogistics() {
        return logistics;
    }

    public void setLogistics(LogisticsBo logistics) {
        this.logistics = logistics;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getPlatformCode() {
        return platformCode;
    }

    public void setPlatformCode(String platformCode) {
        this.platformCode = platformCode;
    }

    public ContactBo getBuyer() {
        return buyer;
    }

    public void setBuyer(ContactBo buyer) {
        this.buyer = buyer;
    }

    public ContactBo getSeller() {
        return seller;
    }

    public void setSeller(ContactBo seller) {
        this.seller = seller;
    }

    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Double getIntegral() {
        return integral;
    }

    public void setIntegral(Double integral) {
        this.integral = integral;
    }

    public Integer getVirtualCoin() {
        return virtualCoin;
    }

    public void setVirtualCoin(Integer virtualCoin) {
        this.virtualCoin = virtualCoin;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public String getRejectReason() {
        return rejectReason;
    }

    public void setRejectReason(String rejectReason) {
        this.rejectReason = rejectReason;
    }

    public List<ChildOrderBo> getGoods() {
        return goods;
    }

    public void setGoods(List<ChildOrderBo> goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "RefundOrderBo{" +
                "_id='" + _id + '\'' +
                ", orderType=" + orderType +
                ", userId='" + userId + '\'' +
                ", shardKey='" + shardKey + '\'' +
                ", originId='" + originId + '\'' +
                ", amount=" + amount +
                ", integral=" + integral +
                ", virtualCoin=" + virtualCoin +
                ", basePrice=" + basePrice +
                ", channel='" + channel + '\'' +
                ", refundSerialNum='" + refundSerialNum + '\'' +
                ", appCode='" + appCode + '\'' +
                ", relatedCommodities=" + relatedCommodities +
                ", goods=" + goods +
                ", reason='" + reason + '\'' +
                ", auditsNum=" + auditsNum +
                ", refundType=" + refundType +
                ", logistics=" + logistics +
                ", images=" + images +
                ", platformCode='" + platformCode + '\'' +
                ", explain='" + explain + '\'' +
                ", buyer=" + buyer +
                ", seller=" + seller +
                ", rejectReason='" + rejectReason + '\'' +
                '}';
    }
}
