package com.common.utils;

import com.common.config.exception.ParameterException;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by boluome on 2017/6/29.
 */
public class CheckUtils {
    private static final Logger logger = LoggerFactory.getLogger(CheckUtils.class);

    public static void checkParams(Object object,String[] params) throws ParameterException {
        for (String param : params){
            try {
                Object parameter = PropertyUtils.getProperty(object,param);
                check(parameter,param);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public static void checkParamsMap(Map<String,Object> map, String[] params) throws ParameterException {
        for (String param : params){
           Object parameter = MapUtils.getObject(map,param);
            check(parameter,param);
        }
    }

    private static void check(Object parameter,String param) throws ParameterException {
        if (parameter instanceof String){
            if (StringUtils.isBlank((String) parameter)){
                throw new ParameterException(9,"缺少"+param);
            }
        }else if (parameter instanceof Collection){
            if (CollectionUtils.isEmpty((Collection<?>) parameter)){
                throw new ParameterException(9,"缺少"+param);
            }
        }else if (parameter instanceof Object[]){
            Object[] bojArray = (Object[])parameter;
            if (null == bojArray || bojArray.length ==0){
                throw new ParameterException(9,"缺少"+param);
            }
        } else {
            if (null == parameter){
                throw new ParameterException(9,"缺少"+param);
            }
        }
    }
}
