package com.common.model.dto.order;

import com.common.model.bo.order.OrderBo;

/**
 * @Package: pecker.model.dto
 * @Description:
 * @author: jklofs
 * @date: 2018/6/1 下午8:04
 */
public class CalculatingDTO {
    private OrderBo orderBo;

    private BetterCouponDTO betterCouponDTO;

    private DistinguishPlatformDTO distinguishPlatformDTO;

    public OrderBo getOrderBo() {
        return orderBo;
    }

    public void setOrderBo(OrderBo orderBo) {
        this.orderBo = orderBo;
    }

    public BetterCouponDTO getBetterCouponDTO() {
        return betterCouponDTO;
    }

    public void setBetterCouponDTO(BetterCouponDTO betterCouponDTO) {
        this.betterCouponDTO = betterCouponDTO;
    }

    public DistinguishPlatformDTO getDistinguishPlatformDTO() {
        return distinguishPlatformDTO;
    }

    public void setDistinguishPlatformDTO(DistinguishPlatformDTO distinguishPlatformDTO) {
        this.distinguishPlatformDTO = distinguishPlatformDTO;
    }

    @Override
    public String toString() {
        return "CalculatingDTO{" +
                "orderBo=" + orderBo +
                ", betterCouponDTO=" + betterCouponDTO +
                ", distinguishPlatformDTO=" + distinguishPlatformDTO +
                '}';
    }
}
