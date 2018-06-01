package com.common.model.dto.order;

import com.common.model.bo.platform.PlatformContentBo;

import java.util.List;

/**
 * @Package: pecker.model.dto
 * @Description:
 * @author: jklofs
 * @date: 2018/6/1 下午7:56
 */
public class DistinguishPlatformDTO {
    private List<PlatformContentBo> canUsedPlatforms ;

    private List<PlatformContentBo> unUsedPlatforms ;

    public List<PlatformContentBo> getCanUsedPlatforms() {
        return canUsedPlatforms;
    }

    public void setCanUsedPlatforms(List<PlatformContentBo> canUsedPlatforms) {
        this.canUsedPlatforms = canUsedPlatforms;
    }

    public List<PlatformContentBo> getUnUsedPlatforms() {
        return unUsedPlatforms;
    }

    public void setUnUsedPlatforms(List<PlatformContentBo> unUsedPlatforms) {
        this.unUsedPlatforms = unUsedPlatforms;
    }

    @Override
    public String toString() {
        return "DistinguishPlatformDTO{" +
                "canUsedPlatforms=" + canUsedPlatforms +
                ", unUsedPlatforms=" + unUsedPlatforms +
                '}';
    }
}
