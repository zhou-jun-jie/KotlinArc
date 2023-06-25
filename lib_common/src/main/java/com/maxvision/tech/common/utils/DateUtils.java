package com.maxvision.tech.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * user: zjj
 * time: 2022/10/26
 * desc: 时间格式化工具类
 */
public class DateUtils {

    /**
     * 将时间戳转为常见固定格式   yyyy-MM-dd HH:mm:ss
     *
     * @param time long类型参数
     * @return 返回格式: 2019-04-10 01:32:02
     */
    public static String formatYMDHMS(long time) {
        return formatTime(time, "yyyy-MM-dd HH:mm:ss");
    }

    public static String formatYMDHMSNow() {
        return formatTime(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss");
    }

    public static String formatYMDHMS2(long time) {
        return formatTime(time, "yyyyMMddHHmmss");
    }

    /**
     * 将时间戳转为常见固定格式  yyyy-MM-dd HH:mm
     *
     * @param time long类型参数
     * @return 返回格式: 2019-04-10 01:32
     */
    public static String formatYMDHM(long time) {
        return formatTime(time, "yyyy-MM-dd HH:mm");
    }

    /**
     * 将时间戳转为常见固定格式 yyyy-MM-dd
     *
     * @param time long类型参数
     * @return 返回格式: 2019-04-10
     */
    public static String formatYMD(long time) {
        return formatTime(time, "yyyy-MM-dd");
    }

    /**
     * 将时间戳转为常见固定格式2 MM-dd HH:mm:ss
     *
     * @param time long类型参数
     * @return 返回格式    04-10 01:41:39
     */
    public static String formatMMHMS(long time) {
        return formatTime(time, "MM-dd HH:mm:ss");
    }


    /**
     * 将时间戳转为常见固定格式3 HH:mm:ss
     *
     * @param time long类型参数
     * @return 返回格式  01:41:39
     */
    public static String formatMMS(long time) {
        return formatTime(time, "HH:mm:ss");
    }

    /**
     * 将时间戳转为指定格式
     *
     * @param time   时间戳
     * @param format 格式
     */
    public static String formatTime(long time, String format) {
        String str_time;
        SimpleDateFormat sdf = new SimpleDateFormat(format,Locale.getDefault());
        str_time = (time + "").length() >= 10 ? sdf.format(new Date(time)) : sdf.format(new Date(time * 1000L));
        return str_time;
    }


    /**
     * 5. 将指定时间格式转换为时间戳
     *
     * @param s    2019-04-10 10:57
     * @param type yyyy-MM-dd HH:mm:
     */
    public static String dateToStamp(String s, String type) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(type,Locale.getDefault());
            Date date = simpleDateFormat.parse(s);
            if (null != date) {
                long time = date.getTime();
                return String.valueOf(time);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static long dateToStampLong(String s, String type) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(type, Locale.getDefault());
            Date date = simpleDateFormat.parse(s);
            if (null != date) {
                return date.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 将指定时间格式转换为时间戳
     *
     * @param s    2019-04-10 10:57
     * @param type yyyy-MM-dd HH:mm:
     */
    public static Long dateToStamp2(String s, String type) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(type,Locale.getDefault());
            Date date = simpleDateFormat.parse(s);
            if (null != date) {
                return date.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    /**
     * 获取今天周几
     */
    public static String getDay(){
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String day = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
        switch (day) {
            case "1":
                day = "天";
                break;
            case "2":
                day = "一";
                break;
            case "3":
                day = "二";
                break;
            case "4":
                day = "三";
                break;
            case "5":
                day = "四";
                break;
            case "6":
                day = "五";
                break;
            case "7":
                day = "六";
                break;
        }
        return "星期"+day;
    }

    /**
     * 将秒数转化为时分秒格式
     *
     * @param time
     * @return
     */
    public static String getHMS(long time) {
        int temp = (int) time;
        int hh = temp / 3600;
        int mm = (temp % 3600) / 60;
        int ss = (temp % 3600) % 60;
        return (hh < 10 ? ("0" + hh) : hh) + ":" +
                (mm < 10 ? ("0" + mm) : mm) + ":" +
                (ss < 10 ? ("0" + ss) : ss);
    }

    public static Date getDate(String str) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd",Locale.getDefault());
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String dateToString(Date date, String formatType) {
        return new SimpleDateFormat(formatType,Locale.getDefault()).format(date);
    }

    public static Date longToDate(String dateFormat,Long millSec){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat,Locale.getDefault());
        Date date= new Date(millSec);
        return date;
    }

}
