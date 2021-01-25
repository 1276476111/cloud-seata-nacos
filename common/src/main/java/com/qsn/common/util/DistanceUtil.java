package com.qsn.common.util;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;


/**
 * 计算经纬度工具类
 *
 * @author qiusn
 * @date 2020-12-14
 */
@Component
public class DistanceUtil {

    private static double EARTH_RADIUS = 6378.137;

    /**
     * 获取两点间的公里数
     *
     * @param longitudeA A的纬度
     * @param latitudeA  A的经度
     * @param longitudeB B的纬度
     * @param latitudeB  B的经度
     * @return
     */
    private double getDistance(double longitudeA, double latitudeA, double longitudeB, double latitudeB) {
        double lat1 = (Math.PI / 180) * longitudeA;
        double lat2 = (Math.PI / 180) * longitudeB;

        double lon1 = (Math.PI / 180) * latitudeA;
        double lon2 = (Math.PI / 180) * latitudeB;

        // 地球半径
        double R = 6371;

        //       A纬度             B纬度              A的纬度        B的纬度          (B的经度-A的经度）
        double d = Math.acos(Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon2 - lon1)) * R;

        // 两点间距离 km，如果想要米的话，结果*1000就可以了
        return d * 1000;
    }

    /**
     * 根据两个位置的经纬度，来计算两地的距离（单位为KM）, 参数为String类型
     *
     * @param lat1Str 用户纬度
     * @param lng1Str 用户经度
     * @param lat2Str 商家纬度
     * @param lng2Str 商家经度
     * @return 距离 (单位: Km)
     */
    public static Double getDistance(String lat1Str, String lng1Str, String lat2Str, String lng2Str) {
        Double lat1 = Double.parseDouble(lat1Str);
        Double lng1 = Double.parseDouble(lng1Str);
        Double lat2 = Double.parseDouble(lat2Str);
        Double lng2 = Double.parseDouble(lng2Str);

        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double difference = radLat1 - radLat2;
        double mdifference = rad(lng1) - rad(lng2);
        double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(difference / 2), 2)
                + Math.cos(radLat1) * Math.cos(radLat2)
                * Math.pow(Math.sin(mdifference / 2), 2)));

        return new BigDecimal(distance * EARTH_RADIUS).setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
    }

    /**
     * 获取当前用户一定距离以内的经纬度值
     *
     * @param latStr   经度
     * @param lngStr   维度
     * @param distance (单位: m)
     * @return maxLat 最大纬度
     */
    public static Map getAround(String latStr, String lngStr, String distance) {
        Map map = new HashMap(16);

        // 传值给经度
        Double latitude = Double.parseDouble(latStr);
        // 传值给纬度
        Double longitude = Double.parseDouble(lngStr);

        // 获取每度
        Double degree = (24901 * 1609) / 360.0;
        double distanceMile = Double.parseDouble(distance);

        Double mpdLng = Double.parseDouble((degree * Math.cos(latitude * (Math.PI / 180)) + "").replace("-", ""));
        Double dpmLng = 1 / mpdLng;
        Double radiusLng = dpmLng * distanceMile;
        // 获取最小经度
        Double minLng = longitude - radiusLng;
        // 获取最大经度
        Double maxLng = longitude + radiusLng;

        Double dpmLat = 1 / degree;
        Double radiusLat = dpmLat * distanceMile;
        // 获取最小纬度
        Double minLat = latitude - radiusLat;
        // 获取最大纬度
        Double maxLat = latitude + radiusLat;

        map.put("minLat", minLat + "");
        map.put("maxLat", maxLat + "");
        map.put("minLng", minLng + "");
        map.put("maxLng", maxLng + "");

        return map;
    }

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }


    /**
     * 通过经纬度计算AB两点间的距离
     *
     * @param longitude1 A点经度
     * @param latitude1  A点纬度
     * @param longitude2 B点经度
     * @param latitude2  B点纬度
     * @return  返回距离  单位：km
     */
    public static Double getDistance2(double longitude1, double latitude1, double longitude2, double latitude2) {
        double radLat1 = rad(latitude1);
        double radLat2 = rad(latitude2);
        double a = radLat1 - radLat2;
        double b = rad(longitude1) - rad(longitude2);
        double distance = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) + Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        distance = distance * EARTH_RADIUS;
        Map<String, Object> map = new HashMap<String, Object>();
        BigDecimal decimal = new BigDecimal(distance);
        // 结果保留2位小数
        distance = decimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        // {distance=700.0, units=km}
        return distance;
    }

    /**
     * 根据经纬度，计算两点间的距离
     *
     * @param longitude1 第一个点的经度
     * @param latitude1  第一个点的纬度
     * @param longitude2 第二个点的经度
     * @param latitude2  第二个点的纬度
     * @return 返回距离 单位千米
     */
    public static double getDistance3(double longitude1, double latitude1, double longitude2, double latitude2) {
        // 纬度
        double lat1 = Math.toRadians(latitude1);
        double lat2 = Math.toRadians(latitude2);
        // 经度
        double lng1 = Math.toRadians(longitude1);
        double lng2 = Math.toRadians(longitude2);
        // 纬度之差
        double a = lat1 - lat2;
        // 经度之差
        double b = lng1 - lng2;
        // 计算两点距离的公式
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(b / 2), 2)));
        // 弧长乘地球半径, 返回单位: 千米
        s =  s * EARTH_RADIUS;
        return s;
    }

}
