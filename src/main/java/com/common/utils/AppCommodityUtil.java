package com.common.utils;

import org.apache.commons.lang3.StringUtils;

public class AppCommodityUtil {
    public static String COMMODITY_PREFIX = "app_commodity_";
    public static String COMMODITY_DETAIL_PREFIX = "app_commodity_detail_";
    public static String COMMODITY_IMG_PREFIX = "app_commodity_img_";
    public static String COMMODITY_SPECIFICATION_PREFIX = "app_commodity_specification_";
    public static String COMBINATION_COMMODITY_PREFIX = "app_combination_commodity_";
    public static String SORT_PREFIX = "app_sort_";
    public static String COMMODITY_SORT_PREFIX = "app_commodity_sort_";
    public static String FREIGHT_PREFIX = "app_freight_";
    public static String FREIGHT_TEMPLATE_PREFIX = "app_freight_template_";
    public static String FREIGHT_TEMPLATE_CITY_PREFIX = "app_freight_template_city_";
    public static String PROMOTION_ACTIVITY_PREFIX = "app_promotion_activity_";
    public static String PROMOTION_COMMODITY_PREFIX = "app_promotion_commodity_";
    private static ThreadLocal<String> LOCAL_APP_CODE = new ThreadLocal();

    public AppCommodityUtil() {
    }

    public static String getCommodityTableName(String applicationName) {
        return COMMODITY_PREFIX + applicationName;
    }

    public static String getCommodityDetailTableName(String applicationName) {
        return COMMODITY_DETAIL_PREFIX + applicationName;
    }

    public static String getCommodityImgTableName(String applicationName) {
        return COMMODITY_IMG_PREFIX + applicationName;
    }

    public static String getCommoditySpecificationTableName(String applicationName) {
        return COMMODITY_SPECIFICATION_PREFIX + applicationName;
    }

    public static String getCombinationCommodityTableName(String applicationName) {
        return COMBINATION_COMMODITY_PREFIX + applicationName;
    }

    public static String getSortTableName(String applicationName) {
        return SORT_PREFIX + applicationName;
    }

    public static String getCommoditySortTableName(String applicationName) {
        return COMMODITY_SORT_PREFIX + applicationName;
    }

    public static String getFreightTableName(String applicationName) {
        return FREIGHT_PREFIX + applicationName;
    }

    public static String getFreightTemplateTableName(String applicationName) {
        return FREIGHT_TEMPLATE_PREFIX + applicationName;
    }

    public static String getFreightTemplateCityTableName(String applicationName) {
        return FREIGHT_TEMPLATE_CITY_PREFIX + applicationName;
    }

    public static String getPromotionActivityTableName(String applicationName) {
        return PROMOTION_ACTIVITY_PREFIX + applicationName;
    }

    public static String getPromotionCommodityTableName(String applicationName) {
        return PROMOTION_COMMODITY_PREFIX + applicationName;
    }

    public static void setAppCode(String appCode) {
        LOCAL_APP_CODE.set(appCode);
    }

    public static String getAppCode() {
        return (String)LOCAL_APP_CODE.get();
    }

    public static String getCommodityTableName() {
        return getTableName(COMMODITY_PREFIX, "commodity");
    }

    public static String getCommodityDetailTableName() {
        return getTableName(COMMODITY_DETAIL_PREFIX, "commodity_detail");
    }

    public static String getCommodityImgTableName() {
        return getTableName(COMMODITY_IMG_PREFIX, "commodity_img");
    }

    public static String getCommoditySpecificationTableName() {
        return getTableName(COMMODITY_SPECIFICATION_PREFIX, "commodity_specification");
    }

    public static String getCombinationCommodityTableName() {
        return getTableName(COMBINATION_COMMODITY_PREFIX, "combination_commodity");
    }

    public static String getSortTableName() {
        return getTableName(SORT_PREFIX, "sort");
    }

    public static String getCommoditySortTableName() {
        return getTableName(COMMODITY_SORT_PREFIX, "commodity_sort");
    }

    public static String getFreightTableName() {
        return getTableName(FREIGHT_PREFIX, "freight");
    }

    public static String getFreightTemplateTableName() {
        return getTableName(FREIGHT_TEMPLATE_PREFIX, "freight_template");
    }

    public static String getFreightTemplateCityTableName() {
        return getTableName(FREIGHT_TEMPLATE_CITY_PREFIX, "freight_template_city");
    }

    public static String getPromotionActivityTableName() {
        return getTableName(PROMOTION_ACTIVITY_PREFIX, "promotion_activity");
    }

    public static String getPromotionCommodityTableName() {
        return getTableName(PROMOTION_COMMODITY_PREFIX, "promotion_commodity");
    }

    private static String getTableName(String prefix, String defaultName) {
        String appCode = (String)LOCAL_APP_CODE.get();
        return StringUtils.isBlank(appCode)?defaultName:prefix + appCode;
    }
}
