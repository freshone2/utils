package com.common.route.base;

import org.springframework.web.bind.annotation.*;

@RestController
public interface MallInSideRoute {

    /**
     * 商品详情
     *
     * @param commodityIds
     * @return
     */
    @RequestMapping(value = "/mall/v1/commodities/message", method = RequestMethod.GET)
    public String commoditiesMessage(@RequestHeader("appCode") String appCode, @RequestParam("commodityIds") String commodityIds);

    /**
     * 商品列表
     *
     * @param appCode 渠道code
     * @param categoryId 分类id
     * @param filter 过滤条件
     * @param limit
     * @param offset
     * @return
     */
    @RequestMapping(value = "/mall/v1/commodities", method = RequestMethod.GET)
    public String commodities(
            @RequestParam(value = "categoryId",required = false) Integer categoryId,
            @RequestParam(value = "brandId",required = false) Integer brandId,
            @RequestParam(value = "params",required = false)String params,
            @RequestParam(value = "filter", required = false, defaultValue = "sales") String filter,
            @RequestParam(value = "limit", required = false, defaultValue = "1") int limit,
            @RequestParam(value = "offset", required = false, defaultValue = "20") int offset,
            @RequestHeader("appCode")String appCode);

}
