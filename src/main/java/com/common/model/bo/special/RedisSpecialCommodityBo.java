package com.common.model.bo.special;

import com.common.model.bo.base.ProxyHashMap;
import org.apache.commons.collections4.MapUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: pecker.model.bo.special
 * @Description:
 * @author: jklofs
 * @date: 2018/5/18 上午10:13
 */
public class RedisSpecialCommodityBo extends ProxyHashMap<String,String> {
    public static final String WEEK_DAY = "weekDay";

    public static final String MONTH_DAY = "monthDay";

    public static final String HOUR_DAY = "hourDay";

    public static final String START_DATE = "startDate";

    public static final String END_DATE = "endDate";

    public static final String ACTIVITY_ID = "activityId";

    public static final String PREFERENTIAL_TYPE = "preferentialType";

    public static final String VALUE = "value";

    public static final String MAX_PURCHASED = "maxPurchased";

    public static final String STATUS = "status";

    public static final String ACTIVITY_NAME = "activityName";

    public RedisSpecialCommodityBo() {
    }

    public RedisSpecialCommodityBo(Map<String, String> map) {
        super(map);
    }

    public RedisSpecialCommodityBo(int init) {
        super(init);
    }

    public String getWeekDay() {
        return get(WEEK_DAY);
    }

    public String getMonthDay() {
        return get(MONTH_DAY);
    }

    public String getHourDay() {
        return get(HOUR_DAY);
    }

    public Long getStartDate() {
        return MapUtils.getLong(this,START_DATE);
    }

    public Long getEndDate() {
        return MapUtils.getLong(this,END_DATE);
    }

    public Integer getActivityId() {
        return MapUtils.getInteger(this,ACTIVITY_ID);
    }

    public int getPreferentialType() {
        return MapUtils.getIntValue(this,PREFERENTIAL_TYPE,0);
    }

    public double getVALUE() {
        return MapUtils.getDoubleValue(this,VALUE,0);
    }

    public int getMaxPurchased() {
        return MapUtils.getIntValue(this,MAX_PURCHASED,-1);
    }

    public int getSTATUS() {
        return MapUtils.getIntValue(this,STATUS,0);
    }

    public String getActivityName() {
        return get(ACTIVITY_NAME);
    }

    public void setWeekDay(String weekDay) {
        put(WEEK_DAY,weekDay);
    }

    public void setMonthDay(String monthDay) {
        put(MONTH_DAY,monthDay);
    }

    public void setHourDay(String hourDay) {
        put(HOUR_DAY,hourDay);
    }

    public void setStartDate(String startDate) {
        put(START_DATE,startDate);
    }

    public void setEndDate(String endDate) {
        put(END_DATE,endDate);
    }

    public void setActivityId(String activityId) {
        put(ACTIVITY_ID,activityId);
    }

    public void setPreferentialType(String preferentialType) {
        put(PREFERENTIAL_TYPE,preferentialType);
    }

    public void setVALUE(String value) {
        put(VALUE,value);
    }

    public void setMaxPurchased(String maxPurchased) {
        put(MAX_PURCHASED,maxPurchased);
    }

    public void setSTATUS(String status) {
        put(STATUS,status);
    }

    public void setActivityName(String activityName) {
        put(ACTIVITY_NAME,activityName);
    }
}
