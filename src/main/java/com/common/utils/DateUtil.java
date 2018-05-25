package com.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by liuxin on 16/12/24.
 */
public class DateUtil {

    public final static String defaultDatePattern = "yyyy-MM-dd";
    public final static String nimabi = "MM月dd日";
    public final static String defaultDayPattern = "yyyy-MM";
    public final static String defaultYearPattern = "yyyy";
    public final static String hd_DATE = "yyyyMM";
    public final static String easyDatePatternHour2 = "yyMMddHH";
    public final static String easyDatePattern2 = "yyMMdd";
    public final static String easyDatePattern = "yyyyMMdd";
    public final static String easyDatePatternHour = "yyyyMMddHH";
    public final static String reasyDatePattern = "ddMMyyyy";
    public final static String easyDatePatternS = "ddMMyyyy";
    public final static String dateChinaPattern = "yyyy年MM月dd日";
    public final static String chinaDateTime = "yyyy年MM月dd日  HH时mm分ss秒";
    public final static String complicatedDatePattern = "yyyy-MM-dd HH:mm:ss";
    public final static String endDatePattern = "yyyy-MM-dd HH:mm";
    public final static String complicatedDatePatterns = "yyyy-MM-dd";
    public final static String strtime = "yyyyMMddHHmmss";
    public final static String timehom = "yyyyMMddHHmmssSSS";
    public final static String taskTime = "yyyyMMddHHmm";
    public final static String outtime = "yyyyMMdd HH:mm:ss";
    public final static String refundtime = "MM-dd HH:mm";
    public final static String orderDate = "yyyy/MM/dd";
    public final static String TMIN = "HH:mm:ss";
    public final static String QIEGE = "HH:mm";
    public final static String ESBTMIN = "HHmmss";
    public final static String MM="MM";

    public static String getCurrentDate(Date date){

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    public static String getMovieDate(){
        SimpleDateFormat simpleDate=new SimpleDateFormat("MM-DD HH:mm");
        return simpleDate.format(new Date());
    }

    public static String StrTime(String formax) {
        DateFormat format = new SimpleDateFormat(formax);
        return format.format(new Date());
    }
    /**
     * 返回日子 YYYYMM
     *
     */
    public static String SystemHdDate() {
        DateFormat format = new SimpleDateFormat(hd_DATE);
        return format.format(new Date());
    }

    /**
     * 返回系统当前时间
     * "yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static String SystemDate() {
        DateFormat format = new SimpleDateFormat(
                complicatedDatePattern);
        return format.format(new Date());
    }

    public static Date getnewDate() {
        return new Date();
    }

    /**
     * 得到目前系统时间，格式为 Date
     *
     * @return Date
     */
    public static Date getNowSystemTimeForDate() {

        return Calendar.getInstance().getTime();
    }

    /**
     * 得到目前系统时间，格式为："yyyy-MM-dd hh:mm:ss"
     *
     * @return 系统时间的字符串表示形式，格式为："yyMMdd"
     */
    public static String getEasySysDateAL() {
        SimpleDateFormat sdf = new SimpleDateFormat(complicatedDatePattern);
        return sdf.format(getnewDate());
    }

    /**
     * 得到目前系统时间，格式为："yyMMdd"
     *
     * @return 系统时间的字符串表示形式，格式为："yyMMdd"
     */
    public static String getEasySysDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(easyDatePattern2);
        return sdf.format(getnewDate());
    }

    /**
     * 得到目前系统时间，格式为："ddMMyyyy"
     *
     * @return 系统时间的字符串表示形式，格式为："ddMMyyyy"
     */
    public static String getEasySysDateend() {
        SimpleDateFormat sdf = new SimpleDateFormat(easyDatePatternS);
        return sdf.format(getnewDate());
    }

    /**
     * 得到目前系统时间，格式为："yyyyMMddHHmmss"
     *
     * @return 系统时间的字符串表示形式，格式为："yyyyMMddHHmmss"
     */
    public static String getNowSystemTime() {

        SimpleDateFormat sdf = new SimpleDateFormat("");
        return sdf.format(getnewDate());
    }

    /**
     * 得到目前系统时间的3位毫秒值，格式为："SSS"
     *
     * @return 系统时间的毫秒值，格式为："SSS"
     */
    public static String getNowSystemMillisecond() {

        SimpleDateFormat sdf = new SimpleDateFormat("SSS");
        return sdf.format(getnewDate());
    }

    /**
     * 得到目前系统时间，格式为："yyyyMMdd"
     *
     * @return 系统时间的字符串表示形式，格式为："yyyyMMdd"
     */
    public static String getSysDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(getnewDate());
    }
    /**
     * 返回系统时间  HH:mm:ss
     * @return
     */
    public static String getSysTIME() {
        SimpleDateFormat sdf = new SimpleDateFormat(TMIN);
        return sdf.format(getnewDate());
    }
    /**
     * 得到目前系统时间，格式为："HHmmss"
     *
     * @return 系统时间的字符串表示形式，格式为："HHmmss"
     */
    public static String getSysTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
        return sdf.format(getnewDate());
    }

    /**
     * 日期往前推或往后推
     *
     * @param datastr
     *            String datastr是YYYY-MM-dd格式的日期字符串
     * @param a
     *            int 当a>0向前推n天后的日期,当a<0,向后退n天后的日期
     * @return 返回YYYY-MM-dd 格式处理后的日期
     */
    public static String compareDateOnDay(String datastr, int a)
            throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(complicatedDatePatterns);
        Date date = sdf.parse(datastr);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, a);
        return sdf.format(calendar.getTime());
    }
    /**
     * 日期往前推或往后推
     *
     * @param datastr
     *            String datastr是YYYY-MM-dd HH:mm:ss格式的日期字符串
     * @param datastr
     * 				指定格式
     * @param a
     *            int 当a>0向前推n天后的日期,当a<0,向后退n天后的日期
     * @return 返回YYYY-MM-dd 格式处理后的日期
     */
    public static String compareDateOnDay(String datastr,String farmaxt, int a)
            throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat(farmaxt);
        Date date = sdf.parse(datastr);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, a);
        return sdf.format(calendar.getTime());
    }
    /**
     * 将Str时间转化成long行时间
     * @param date
     * @param inputformat
     * @return
     * @throws ParseException
     */
    public static long StrDateToLong (String date,String inputformat) throws ParseException{
        Date enddate=parse(inputformat, date);
        return StrDateToLong(enddate);
    }

    public static int getWeekDay(long day){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(day));
        int weekIndex = cal.get(Calendar.DAY_OF_WEEK) - 1;
        System.out.println(weekIndex);
        if(weekIndex<0){
            weekIndex = 0;
        }
        return weekIndex;
    }

    public static int getMonthDay(long day){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(day));
        int monthIndex = cal.get(Calendar.DAY_OF_MONTH);
        System.out.println(monthIndex);
        if(monthIndex<0){
            monthIndex = 0;
        }
        return monthIndex;
    }

    /**
     * 将date时间转long型时间
     * @param date
     * @return
     */
    public static long StrDateToLong (Date date){
        return date.getTime();
    }
    /**
     * 比较两个日期的大小
     *
     * @param format 日期格式字符串常量;
     * @param DATE1 时间1;
     * @param DATE2 时间2;
     * @return 如果时间1大于时间2前返回“1”,若时间1小于时间2后返回“-1”,相等返回0;
     */
    public static int compareDatedifference(String format, String DATE1, String DATE2) throws Exception {
        DateFormat df = new SimpleDateFormat(format);
        Date dt1 = df.parse(DATE1);
        Date dt2 = df.parse(DATE2);
        if (dt1.getTime() > dt2.getTime()) {
            return 1;
        } else if (dt1.getTime() < dt2.getTime()) {
            return -1;
        }
        return 0;
    }

    /**
     * 日期往前推或往后推
     *
     * @param datastr
     *            String datastr是YYYY-MM-dd HH:mm:ss格式的日期字符串
     * @param a
     *            String 当a>0向前推n天后的日期,当a<0,向后退n天后的日期
     * @return 返回YYYY-MM-dd 格式处理后的日期
     */
    public static String compareDateOnDay(String datastr, String a)
            throws Exception {
        return compareDateOnDay(datastr, Integer.parseInt(a));
    }

    /**
     * 得到 当前日期和dateNum天数的日期
     *
     * @param dateNum
     *            天数，可以是正整书，或者负整数
     * @return
     */
    public static String getAddDateString(int dateNum) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, dateNum);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

    /**
     * 比较两个日期，返回它们之间相差的天数,不足一天返回0
     *
     * @param date1
     *            java.util.Date
     * @param date2
     *            java.util.Date
     * @return 相差的天数，如果 date1 小于 date2 返回 负数 <br>
     */
    public static int compareDateOnDay(Date date1, Date date2) {
        long ss = date1.getTime() - date2.getTime();
        long day = 24 * 60 * 60 * 1000;
        return Integer.parseInt(ss / day + "");
    }

    /**
     * 取an天后的时间
     *
     * @param an 大于0向前算，小于0向后算
     * @param farmat
     *            以何种格式输出
     * @return
     * @throws ParseException
     */
    public static String DateDiffer(int an, String farmat)
            throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(farmat);
        Date date = sdf.parse((farmat));
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, an);
        return sdf.format(calendar.getTime());
    }

    /**
     * 取得一个yyyy年MM月dd日 HH时mm分ss秒 格式的时间
     *
     * @return
     */
    public static String getChinaDateTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(chinaDateTime);
        return simpleDateFormat.format(new Date());
    }

    /**
     * 格式化日期 原日期默认为"yyyymm"
     *
     * @param newformat
     *            匹配模式
     * @param datestr
     *            日期
     * @return
     * @throws ParseException
     */
    public static String format(String newformat, String datestr)
            throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = simpleDateFormat.parse(datestr);
        simpleDateFormat = new SimpleDateFormat(newformat);
        return simpleDateFormat.format(date);
    }
    /**
     * 将string 日期转换成Date时间
     * @param formatstr
     * @param datestr
     * @return
     * @throws ParseException
     */
    public static Date formatDate(String formatstr, String datestr)
            throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatstr);
        Date date = simpleDateFormat.parse(datestr);
        return date;
    }

    /**
     * 日期转换
     * @param newformat	新日期格式
     * @param oldfarmat	原日期格式
     * @param datestr	日期
     * @return
     * @throws ParseException
     */
    public static String format(String newformat,String oldfarmat, String datestr)
            throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(oldfarmat);
        Date date = simpleDateFormat.parse(datestr);
        simpleDateFormat = new SimpleDateFormat(newformat);
        return simpleDateFormat.format(date);
    }
    /**
     * 格式化日期
     *
     * @param date
     *            日期
     * @return
     */
    public static String format(Date date) {
        return format(easyDatePattern, date);
    }

    /**
     * 格式化日期
     *
     * @param pattern
     *            格式化模式
     * @param date
     *            日期
     * @return
     */
    public static String format(String pattern, Date date) {
        return new SimpleDateFormat(pattern == null ? defaultDatePattern
                : pattern).format(date);
    }

    /**
     * 转换日期
     *
     * @param pattern
     *            匹配模式
     * @param datestr
     *            日期
     * @return
     * @throws ParseException
     */
    public static Date parse(String pattern, String datestr)
            throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.parse(datestr);
    }

    /**
     * 得到目前系统时间，格式为："yyyy-MM-dd"
     *
     * @return 系统时间的字符串表示形式，格式为："yyyy-MM-dd"
     */
    public static String getSysDateDefault() {
        SimpleDateFormat sdf = new SimpleDateFormat(defaultDatePattern);
        return sdf.format(getnewDate());
    }

    /**
     * 得到目前系统详细时间，格式为："yyyy年MM月dd日"
     *
     * @return 系统时间的字符串表示形式，格式为："yyyy年MM月dd日"
     */
    public static String getSysDateChina() {
        SimpleDateFormat sdf = new SimpleDateFormat(dateChinaPattern);
        return sdf.format(getnewDate());
    }

    /**
     * 得到格式为yyyyMMdd的会记日期字符串
     */
    public static String getBansfDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(easyDatePattern);
        return sdf.format(getnewDate());
    }
    /**
     * 月加减
     *
     * @param data
     *            日期满足yyyyMM
     * @param ln
     *            相差后的日期 n<倒退n月后的日期；n大于1为提前几月后的日期
     * @return
     * @throws ParseException
     */
    public static String compareMonthdifference(String data, int ln) {
        String year = null;
        String month = null;
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(df.parse(data.substring(0, 6)));
            calendar.add(Calendar.MONTH, ln);
            year = (calendar.get(Calendar.YEAR)) + "";
            month = (calendar.get(Calendar.MONTH) + 1) + "";
            month = month.length() == 1 ? "0" + month : month;
        } catch (Exception e) {
            return data;
        }
        return year + month;
    }
    /**
     * 月加减
     *
     * @param data
     *            日期满足yyyyMM
     * @param ln
     *            相差后的日期 n<倒退n月后的日期；n大于1为提前几月后的日期
     * @return
     * @throws ParseException
     */
    public static String compareMonthdifference2(String data, int ln) {
        String year = null;
        String month = null;
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(df.parse(data.substring(0, 6)));
            calendar.add(Calendar.MONTH, ln);
            year = (calendar.get(Calendar.YEAR)) + "";
            month = (calendar.get(Calendar.MONTH) + 1) + "";
            month = month.length() == 1 ? "0" + month : month;
        } catch (Exception e) {
            return data;
        }
        return year +"-"+ month;
    }
    /**
     * 计算两个月的时间查以月计算
     *
     * @param statdata
     *            yyyyMM
     * @param enddata
     *            yyyyMM
     * @return 若enddata大于statdata 返回相差月份值大于0， 若enddata小于statdata
     *         返回相差月份值小于0，相对返回0
     */
    public static int compareMonthsel(String statdata, String enddata) {
        int i = 1;
        int j = 0;
        try {
            boolean flag = true;
            if (maxormin(statdata, enddata) == 0) {
                return j;
                // statdata<enddata
            } else if (maxormin(statdata, enddata) == -1) {
                String tempdate = "";
                while (flag) {
                    j++;
                    tempdate = compareMonthdifference(statdata, i);
                    if (maxormin(tempdate, enddata) >= 0) {
                        flag = false;
                    } else {
                        statdata = tempdate;
                    }
                }
                return j;
                // statdata>enddata
            } else if (maxormin(statdata, enddata) == 1) {
                String tempdate = "";
                while (flag) {
                    j++;
                    tempdate = compareMonthdifference(enddata, i);
                    if (maxormin(tempdate, statdata) >= 0) {
                        flag = false;
                    } else {
                        enddata = tempdate;
                    }
                }
                return -j;
            }
        } catch (Exception e) {
            return 0;
        }
        return j;
    }

    /**
     * 比较两个日期的大小
     *
     * @param date1
     *            yyyyMM
     * @param date2
     *            yyyyMM
     * @return date1>date2 返回 1； date1==date2返回 0 ；date1<date2 返回-1
     * @throws ParseException
     */
    public static int maxormin(String date1, String date2)
            throws ParseException {
        return maxormin(date1,date2,"yyyyMM");
    }
    /**
     * 判断两个时间的大小
     * @param date1
     * @param date2
     * @param formax 格式定义
     * @return date1>date2 返回 1； date1==date2返回 0 ；date1<date2 返回-1
     * @throws ParseException
     */
    public static int maxormin(String date1, String date2,String formax)throws ParseException {
        SimpleDateFormat dff = new SimpleDateFormat(formax);
        Date dt1 = dff.parse(date1);
        Date dt2 = dff.parse(date2);
        if (dt1.getTime() == dt2.getTime()) {
            return 0;
        } else if (dt1.getTime() < dt2.getTime()) {
            return -1;
        } else {
            return 1;
        }
    }
    /**
     * 日期字符串格式转换
     * @param date 日期字符串
     * @param formax1 格式1输入字符串格式
     * @param formax2 格式2输出字符串格式
     * @return
     * @throws Exception
     */
    public static String formaxToformax(String date,String formax1,String formax2)throws Exception{
        SimpleDateFormat dff1 = new SimpleDateFormat(formax1);
        Date dt1 = dff1.parse(date);
        SimpleDateFormat dff2 = new SimpleDateFormat(formax2);
        return dff2.format(dt1);
    }
    /**
     * 计算两个日期想差月份
     * @param date1
     * @param date2
     * @return
     */
    public static int getMonthSpace(Date date1,Date date2){
        int resut=0;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            Calendar min = Calendar.getInstance();
            Calendar max = Calendar.getInstance();
            min.setTime(sdf.parse(sdf.format(date1)));
            min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

            max.setTime(sdf.parse(sdf.format(date2)));
            max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

            Calendar curr = min;
            while (curr.before(max)) {
                resut=resut+1;
                curr.add(Calendar.MONTH, 1);
            }
            while (max.before(curr)) {
                resut=resut-1;
                max.add(Calendar.MONTH, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resut;
    }
    /**
     * 将日期date类型的获取指定格式的data类型
     * @param date
     * @param format
     * @return
     * @throws Exception
     */
    public static Date formaTOformatDate(Date date,String format)throws Exception{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date dates = simpleDateFormat.parse(simpleDateFormat.format(date));
        return dates;
    }
    /**
     * 该方法主要作用是计算两个日期的相差天数
     * @param smdate 日期1
     * @param bdate 日期2
     * @return
     * @throws Exception
     */
    public static int timedifference(Date smdate,Date bdate)throws Exception{

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        smdate=sdf.parse(sdf.format(smdate));
        bdate=sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time2-time1)/(1000*3600*24);
        return Integer.parseInt(String.valueOf(between_days));
    }
    /**
     * 该方法主要作用是计算两个日期的相差天数
     * @param smdate 第一个字符串日期
     * @param format1 第一个字符串日期格式
     * @param bdate 第二个日期字符串
     * @param format2 第二个日期字符串格式
     * @return
     * @throws Exception
     */
    public static int timedifference(String smdate,String format1,String bdate,String format2)throws Exception{
        SimpleDateFormat dff1 = new SimpleDateFormat(format1);
        Date dt1 = dff1.parse(smdate);
        SimpleDateFormat dff2 = new SimpleDateFormat(format2);
        Date dt2 = dff2.parse(bdate);
        return timedifference(dt1,dt2);
    }
    /**
     * 日期加减发后的日期
     * @param date 开始日期
     * @param a 加减进度
     * @return 返回加减后的日期
     */
    public static Date addDate(Date date,int a){
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.DAY_OF_YEAR,10);
        return rightNow.getTime();
    }
    /**
     * 日期加减发后的日期
     * @param datestr 开始日期
     * @param a 加减进度
     * @return 返回加减后的日期
     * @throws ParseException
     */
    public static Date addDate(String datestr,String format,int a) throws ParseException{
        SimpleDateFormat sdf=new SimpleDateFormat(format);
        Date date=sdf.parse(datestr);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        rightNow.add(Calendar.DAY_OF_YEAR, a);
        return rightNow.getTime();
    }
    /**
     * 返回数据日期String
     * @param datestr 传人的string日期
     * @param format 传人的日期格式
     * @param format1 返回的日期格式
     * @param a
     * @return
     * @throws ParseException
     */
    public static String addDate(String datestr,String format,String format1,int a) throws ParseException{
        SimpleDateFormat sdfs=new SimpleDateFormat(format);
        return sdfs.format(addDate(datestr,format,a));
    }
    /**
     * 返回系统日期
     * @param date
     * @return
     */
    public static String getDate(Object date){
        if(date!=null){
            Date t_date=(Date) date;
            return format(complicatedDatePattern, t_date);
        }
        return "";
    }
    /**
     * 按天获取时间段列表
     * @param dBegin
     * @param dEnd
     * @return
     */
    public static List<String> findDates_Day(Date dBegin, Date dEnd) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<String> lDate = new ArrayList<String>();
        lDate.add(sdf.format(dBegin));
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后
        while (dEnd.after(calBegin.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(sdf.format(calBegin.getTime()));
        }
        return lDate;
    }
    /**
     * 获取两个时间的月列表
     * @param dBegin
     * @param dEnd
     * @return
     */
    public static List<String> findDates_Moth(Date dBegin, Date dEnd) {
        List<String> result = new ArrayList<String>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            Calendar min = Calendar.getInstance();
            Calendar max = Calendar.getInstance();
            min.setTime(sdf.parse(sdf.format(dBegin)));
            min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
            max.setTime(sdf.parse(sdf.format(dEnd)));
            max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
            Calendar curr = min;
            while (curr.before(max)) {
                result.add(sdf.format(curr.getTime()));
                curr.add(Calendar.MONTH, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 获取两个时间的月列表
     * @param dBegin
     * @param dEnd
     * @return
     */
    public static List<String> findDates_Moth(Date dBegin, Date dEnd,String format) {
        List<String> result = new ArrayList<String>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Calendar min = Calendar.getInstance();
            Calendar max = Calendar.getInstance();
            min.setTime(sdf.parse(sdf.format(dBegin)));
            min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);
            max.setTime(sdf.parse(sdf.format(dEnd)));
            max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);
            Calendar curr = min;
            while (curr.before(max)) {
                result.add(sdf.format(curr.getTime()));
                curr.add(Calendar.MONTH, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 获取两个时间的年列表
     * @param dBegin
     * @param dEnd
     * @return
     */
    public static List<String> findDates_Year(Date dBegin, Date dEnd) {
        List<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        int iBegin=Integer.parseInt(sdf.format(dBegin));
        int iEnd=Integer.parseInt(sdf.format(dEnd));
        int cs=iEnd-iBegin;
        if(cs>=0){
            result.add(iBegin+"");
            for (int i = 0; i < cs; i++) {
                result.add((iBegin+(i+1))+"");
            }
        }
        return result;
    }

}
