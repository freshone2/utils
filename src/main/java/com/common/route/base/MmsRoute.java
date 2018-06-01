package com.common.route.base;

import com.common.model.bo.coupon.CouponDTO;
import com.common.model.dto.ResultDTO;
import com.common.model.dto.promotion.IntegralPublishDTO;
import com.common.model.dto.task.TaskDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 内部调用接口
 * Created by wangwei on 2018/5/14.
 */
public interface MmsRoute {
    /**
     * 下线优惠券
     * @param taskDTO
     * @return
     */
    @RequestMapping(value = "/v1/coupon/offline", method = RequestMethod.PUT)
    ResultDTO offlineCouponTask(@RequestBody TaskDTO taskDTO);

    /**
     * 上线优惠券
     * @param taskDTO
     * @return
     */
    @RequestMapping(value = "/v1/coupon/online", method = RequestMethod.PUT)
    ResultDTO onlineCouponTask(@RequestBody TaskDTO taskDTO);



    /**
     * 储存券信息
     * activityCouponContentId,userId,distributeTime
     * @return
     */
    @RequestMapping(value = "/v1/coupon", method = RequestMethod.POST)
    ResultDTO createCoupon(@RequestBody CouponDTO couponDTO);

    /**
     * 商品上架
     * @return
     */
    @RequestMapping(value = "/v1/commodity/online", method = RequestMethod.PUT)
    ResultDTO onlineCommodity(@RequestBody TaskDTO taskDTO);

    /**
     * 商品数据更新
     * @return
     */
    @RequestMapping(value = "/v1/commodity", method = RequestMethod.PUT)
    ResultDTO updatCommodity(@RequestBody TaskDTO taskDTO);

    /**
     * 平台活动上线
     *
     * @param activityId 活动id
     * @return
     */
    @RequestMapping(value = "/v1/platform/activity/online", method = RequestMethod.PUT)
    ResultDTO onlinePlatformActivity(@RequestParam("activityId") Integer activityId);

    /**
     * 平台活动下线
     *
     * @param activityId 活动ID
     * @return
     */
    @RequestMapping(value = "/v1/platform/activity/offline", method = RequestMethod.PUT)
    ResultDTO offlineActivity(@RequestParam("activityId") Integer activityId);

    /**
     * 限时上线活动
     *
     * @param params activityId 活动id
     * @return
     */
    @RequestMapping(value = "/discount/online",method = RequestMethod.PUT)
    ResultDTO onlinePromotionActivity(@RequestBody Map<String,Object> params);

    /**
     * 限时下线活动
     *
     * @param params activityId 活动id
     * @return
     */
    @RequestMapping(value = "/discount/offline",method = RequestMethod.PUT)
    ResultDTO offlinePromotionActivity(@RequestBody Map<String,Object> params);

    @RequestMapping(value = "/v1/combination/online", method = RequestMethod.PUT)
    ResultDTO onlineCombination(@RequestBody TaskDTO<String> taskDTO);

    @RequestMapping(value = "/integral/publish",method = RequestMethod.PUT)
    public ResultDTO<Boolean> integralPublish(@RequestBody IntegralPublishDTO data);

    @RequestMapping(value = "/v1/commodity/offline", method = RequestMethod.PUT)
    ResultDTO offlineCombination(@RequestBody TaskDTO<String> taskDTO);

    /**
     * 商品类目
     *
     * @return
     */
    @RequestMapping(value = "/v1/commodity/category", method = RequestMethod.GET)
    public String findCommodityCategories();

}
