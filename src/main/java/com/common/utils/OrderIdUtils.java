package com.common.utils;

import com.common.config.exception.ParameterException;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.*;

/**
 * @Package: pecker.utils
 * @Description:
 * @author: jklofs
 * @date: 2018/3/26 上午9:22
 */
public class OrderIdUtils {
    private static final Random RANDOM = new Random();
    private static final int MAX_RANDOM_NUMBER = 99999999;
    public static final int MOD_INIT = 65535;
    private static final List<String> ALGORITHM_RULE = Arrays.asList("0","1","2","3","4","5","6","7","8","9","a","b","c"
            ,"d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B"
            ,"C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");
    private static final int TYPE_INDEX = 3;

    /**
     * 根据用户ID获取分片
     *
     * @param userId
     * @return
     */
    public static String choiceShardByUserId(String userId){
        return String.format("%05d",userId.hashCode() & MOD_INIT);
    }

    /**
     * 根据订单号/流水号获取分片
     *
     * @param orderId
     * @return
     */
    public static String choiceShardByOrderId(String orderId){
        return orderId.substring(orderId.length()-5);
    }

    /**
     * 根据ID获取订单号类型
     *
     * @param orderId
     * @return
     */
    public static int choiceOrderIdType(String orderId){
        return NumberUtils.toInt(orderId.charAt(TYPE_INDEX)+"");
    }


    /**
     * 转换时间值为62位时间
     *
     * @param dateString
     * @return
     * @throws ParameterException
     */
    public static String dateStringToSixTyString(String dateString) throws ParameterException {
        StringBuilder builder = new StringBuilder("");
        for (int i=0;i<6;i=i+2){
            String charDate = dateString.substring(i,i+2);
            builder.append(tenToSixtyTwo(NumberUtils.toInt(charDate)));
        }
        return builder.toString();
    }

    /**
     * 根据订单，转换出订单天
     *
     * @param orderId
     * @return
     * @throws ParameterException
     */
    public static String choiceDayByOrderId(String orderId) throws ParameterException {
        if (null == orderId){
            return null;
        }
        return sixTyStringToDateString(orderId.substring(0,3));
    }

    /**
     * 根据订单前3位，转换出订单时间
     *
     * @param sixTyString
     * @return
     * @throws ParameterException
     */
    public static String sixTyStringToDateString(String sixTyString) throws ParameterException {
        if (null == sixTyString){
            return null;
        }
        StringBuilder builder = new StringBuilder("");
        for (int i=0;i<3;){
            String charDate = sixTyString.substring(i,++i);
            builder.append(sixtyTwoToTen(charDate));
        }
        return builder.toString();
    }

    public static String tenToSixtyTwo(int num) throws ParameterException {
        if (num > 62){
            throw new ParameterException(-1,"超过最大值");
        }
        return ALGORITHM_RULE.get(num);
    }

    public static int sixtyTwoToTen(String six) throws ParameterException {
        return ALGORITHM_RULE.indexOf(six);
    }
}
