package com.common.model.dto.activity;

import java.util.List;

public class ActivityCartSpecDTO {
    private List<ActivityTypeBo> activityTypeBos;
    private List<CartResponseVo> cartResponseVos;

    public List<ActivityTypeBo> getActivityTypeBos() {
        return activityTypeBos;
    }

    public void setActivityTypeBos(List<ActivityTypeBo> activityTypeBos) {
        this.activityTypeBos = activityTypeBos;
    }

    public List<CartResponseVo> getCartResponseVos() {
        return cartResponseVos;
    }

    public void setCartResponseVos(List<CartResponseVo> cartResponseVos) {
        this.cartResponseVos = cartResponseVos;
    }

    @Override
    public String toString() {
        return "ActivityCartSpecDTO{" +
                "activityTypeBos=" + activityTypeBos +
                ", cartResponseVos=" + cartResponseVos +
                '}';
    }
}
