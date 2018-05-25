package com.common.config.conf;

/**
 * @Package: pecker.config.conf
 * @Description:
 * @author: jklofs
 * @date: 2018/4/9 下午3:19
 */
public enum RefundOrderStatusEnum {
    REFUND_REQUESTING(100,"退款申请中"),
    REFUND_REQUEST_REJECT(110,"退款申请已拒绝"),
    BE_RETURNING_GOODS(120,"退货退款，等待退货"),
    RETURNING_GOODS(130,"退货中"),
    RETURN_GOODS_REJECT(140,"退货退款，商家已拒绝"),
    WAITING_REFUND(150,"等待退款"),
    PAY_BACK(160,"退款中"),
    PAY_BACK_SUCCESS(170,"退款成功"),
    PAY_BACK_REJECT(180,"平台拒绝退款"),
    CANCELLED(190,"已取消"),
    REFUND_FAILED(200,"退款失败")
    ;
    public final int CODE;
    public final String NAME;

    RefundOrderStatusEnum(int CODE, String NAME) {
        this.CODE = CODE;
        this.NAME = NAME;
    }
}
