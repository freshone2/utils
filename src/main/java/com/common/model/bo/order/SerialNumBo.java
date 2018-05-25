package com.common.model.bo.order;

import java.util.List;

/**
 * @Package: pecker.model.bo.order
 * @Description:
 * @author: jklofs
 * @date: 2018/3/30 上午10:03
 */
public class SerialNumBo {
    private String paymentSerial;
    private List<String> refundSerialNumList;

    public String getPaymentSerial() {
        return paymentSerial;
    }

    public void setPaymentSerial(String paymentSerial) {
        this.paymentSerial = paymentSerial;
    }

    public List<String> getRefundSerialNumList() {
        return refundSerialNumList;
    }

    public void setRefundSerialNumList(List<String> refundSerialNumList) {
        this.refundSerialNumList = refundSerialNumList;
    }

    @Override
    public String toString() {
        return "SerialNumBo{" +
                "paymentSerial='" + paymentSerial + '\'' +
                ", refundSerialNumList=" + refundSerialNumList +
                '}';
    }
}
