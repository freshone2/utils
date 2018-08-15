package com.common.route.base;

import com.common.model.bo.coupon.CouponDTO;
import com.common.model.dto.ResultDTO;
import com.common.model.dto.promotion.IntegralPublishDTO;
import com.common.model.dto.task.TaskDTO;
import com.peacock.feather.support.ResponseWrapper;

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
    ResultDTO offlineCouponTask(@RequestHeader("requestId") String requestId,@RequestBody TaskDTO taskDTO);

    /**
     * 上线优惠券
     * @param taskDTO
     * @return
     */
    @RequestMapping(value = "/v1/coupon/online", method = RequestMethod.PUT)
    ResultDTO onlineCouponTask(@RequestHeader("requestId") String requestId,@RequestBody TaskDTO taskDTO);



    /**
     * 储存券信息
     * activityCouponContentId,userId,distributeTime
     * @return
     */
    @RequestMapping(value = "/v1/coupon", method = RequestMethod.POST)
    ResultDTO createCoupon(@RequestHeader("requestId") String requestId,@RequestBody CouponDTO couponDTO);

    /**
     * 商品上架
     * @return
     */
    @RequestMapping(value = "/v1/commodity/online", method = RequestMethod.PUT)
    ResultDTO onlineCommodity(@RequestHeader("requestId") String requestId,@RequestBody TaskDTO taskDTO);

    /**
     * 商品下架
     * @return
     */
    @RequestMapping(value = "/v1/commodity/offline", method = RequestMethod.PUT)
    ResultDTO offlineCommodity(@RequestHeader("requestId")String requestId,@RequestBody TaskDTO<String> taskDTO);

    /**
     * 商品数据更新
     * @return
     */
    @RequestMapping(value = "/v1/commodity", method = RequestMethod.PUT)
    ResultDTO updatCommodity(@RequestHeader("requestId") String requestId,@RequestBody TaskDTO taskDTO);

    /**
     * 平台活动上线
     *
     * @param activityId 活动id
     * @return
     */
    @RequestMapping(value = "/v1/platform/activity/online", method = RequestMethod.PUT)
    ResultDTO onlinePlatformActivity(@RequestHeader("requestId") String requestId,@RequestParam("activityId") Integer activityId);

    /**
     * 平台活动下线
     *
     * @param activityId 活动ID
     * @return
     */
    @RequestMapping(value = "/v1/platform/activity/offline", method = RequestMethod.PUT)
    ResultDTO offlineActivity(@RequestHeader("requestId") String requestId,@RequestParam("activityId") Integer activityId);

    /**
     * 限时上线活动
     *
     * @param params activityId 活动id
     * @return
     */
    @RequestMapping(value = "/discount/online",method = RequestMethod.PUT)
    ResultDTO onlinePromotionActivity(@RequestHeader("requestId") String requestId,@RequestBody Map<String,Object> params);

    /**
     * 限时下线活动
     *
     * @param params activityId 活动id
     * @return
     */
    @RequestMapping(value = "/discount/offline",method = RequestMethod.PUT)
    ResultDTO offlinePromotionActivity(@RequestHeader("requestId") String requestId,@RequestBody Map<String,Object> params);

    @RequestMapping(value = "/v1/combination/online", method = RequestMethod.PUT)
    ResultDTO onlineCombination(@RequestHeader("requestId") String requestId,@RequestBody TaskDTO<String> taskDTO);

    @RequestMapping(value = "/integral/publish",method = RequestMethod.PUT)
    public ResultDTO<Boolean> integralPublish(@RequestHeader("requestId") String requestId,@RequestBody IntegralPublishDTO data);

    @RequestMapping(value = "/v1/combination/offline", method = RequestMethod.PUT)
    ResultDTO offlineCombination(@RequestHeader("requestId") String requestId,@RequestBody TaskDTO<String> taskDTO);

    /**
     * 商品类目
     *
     * @return
     */
    @RequestMapping(value = "/v1/commodity/category", method = RequestMethod.GET)
    String findCommodityCategories(@RequestHeader("requestId") String requestId);

    /**
     * 限时折扣列表
     *
     * @param filter
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/v1/promotion/activities",method = RequestMethod.GET)
     String findPromotionActivities(
            @RequestHeader("requestId") String requestId,
            @RequestHeader(value = "appCode") String appCode
            , @RequestParam(value = "filter",required = false) String filter
            , @RequestParam(name = "page" ,required = false,defaultValue ="1") Integer page
            , @RequestParam(name = "pageSize" ,required = false,defaultValue ="10")  Integer pageSize);

    /**
     * 对账单上传
     *
     * @param appCode
     * @return
     */
    @RequestMapping(value = "/mms/v1/exchange/upload",method = RequestMethod.GET)
     String exChangeUpload(@RequestHeader("appCode")String appCode);

    /**
     * 买赠活动上线
     * @param requestId
     * @param taskDTO
     * @return
     */
    @RequestMapping(value = "/v1/buyGift/online",method = RequestMethod.PUT)
    ResultDTO onlineBuyGift(@RequestHeader(value = "requestId")String requestId,@RequestBody TaskDTO<String> taskDTO);

    /**
     * 买赠活动下线
     * @param requestId
     * @param taskDTO
     * @return
     */
    @RequestMapping(value = "/v1/buyGift/offline",method = RequestMethod.PUT)
    ResultDTO offlineBuyGift(@RequestHeader(value = "requestId")String requestId,@RequestBody TaskDTO<String> taskDTO);

    /**
     * 更新预售活动状态
     * @param requestId
     * @param taskDTO
     * @return
     */
    @RequestMapping(value = "/v1/preSale/status",method = RequestMethod.PUT)
    ResultDTO updatePreSaleStatus(@RequestHeader(value = "requestId")String requestId,@RequestBody TaskDTO<String> taskDTO);

    /**
     * 更新预售活动阶段
     * @param requestId
     * @param taskDTO
     * @return
     */
    @RequestMapping(value = "/v1/preSale/stage",method = RequestMethod.PUT)
    ResultDTO updatePreSaleStage(@RequestHeader(value = "requestId")String requestId,@RequestBody TaskDTO<String> taskDTO);
    
	/**
	 * 更新加价购活动状态
	 * 
	 * @param requestId
	 * @param taskDTO
	 * @return
	 */
	@RequestMapping(value = "/v1/priceMarkupActivity/status", method = RequestMethod.PUT)
	ResponseWrapper<?> updatePriceMarkupActivityStatus(@RequestHeader(value = "requestId") String requestId, @RequestBody TaskDTO<String> taskDTO);

}
