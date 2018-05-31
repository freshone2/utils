package com.common.route.base;

import org.springframework.web.bind.annotation.*;

public interface MallInSideRoute {
    /**
     * 分类:一级类目
     *
     * @return
     */
    @RequestMapping(value = "/mall/v1/categories",method = RequestMethod.GET)
    public String findCategory();

    /**
     * 分类:子集类目
     *
     * @return
     */
    @RequestMapping(value = "/mall/v1/subcategories",method = RequestMethod.GET)
    public String findSubCategory(@RequestParam("categoryId") Integer categoryId);

    /**
     * 商品详情
     *
     * @param commodityIds
     * @return
     */
    @RequestMapping(value = "/mall/v1/commodities/message", method = RequestMethod.GET)
    public String commoditiesMessage(@RequestParam(value = "commodityIds") String commodityIds);

}
