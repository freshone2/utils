package com.common.route.base;

import org.springframework.web.bind.annotation.*;

public interface MallInSideRoute {
    /**
     * 分类:一级类目
     *
     * @return
     */
    @RequestMapping(value = "/mall/v1/categories",method = RequestMethod.GET)
    public String findCategory(@RequestHeader("appCode") String appCode);

    /**
     * 分类:子集类目
     *
     * @param appCode
     * @return
     */
    @RequestMapping(value = "/mall/v1/subcategories",method = RequestMethod.GET)
    public String findSubCategory(@RequestHeader("appCode") String appCode,@RequestParam("categoryId") Integer categoryId);

    /**
     * 商品详情
     *
     * @param appCode
     * @param commodityIds
     * @return
     */
    @RequestMapping(value = "/mall/v1/commodities/message", method = RequestMethod.GET)
    public String commoditiesMessage(@RequestHeader("appCode") String appCode,@RequestParam(value = "commodityIds") String commodityIds);

}
