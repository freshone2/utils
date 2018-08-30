package com.common.config.conf;

/**
 * @Package: pecker.config.conf
 * @Description:
 * @author: jklofs
 * @date: 2018/5/16 下午6:07
 */
public enum  ActivityTypeEnum {
    COUPON("coupon"),
    PLATFORM("platform"),
    PRICE_MARKUP("priceMarkup"),
    ORG_REGION("orgRegion"),
    PRESALE("presale")
    ;

    public final String CODE;


    ActivityTypeEnum(String CODE) {
        this.CODE = CODE;
    }
}
