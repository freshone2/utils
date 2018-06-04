package com.common.route.base;

import com.common.model.dto.ResultDTO;
import com.common.model.dto.commodity.CommodityInfoDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

public interface SapRoute {

    /**
     * sap同步sku信息
     *
     * @return
     */
    @GetMapping(value = "/v1/sap/sync")
    ResultDTO syncSkuMessage();

    /**
     * 获取skuInfomation
     *
     * @param skuSn 商品编号
     * @param wareHouseCode 仓库编号
     * @return
     */
    @GetMapping(value = "/v1/sap/sku")
    ResultDTO<CommodityInfoDTO> getSkuInfomation(@RequestHeader("requestId") String requestId, @RequestParam("skuSn") String skuSn
            , @RequestParam("wareHouseCode") String wareHouseCode);
}
