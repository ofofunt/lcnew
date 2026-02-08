package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//981. 基于时间的键值存储
//设计一个基于时间的键值数据结构，该结构可以在不同时间戳存储对应同一个键的多个值，并针对特定时间戳检索键对应的值。
//
//实现 TimeMap 类：
//
//TimeMap() 初始化数据结构对象
//void set(String key, String value, int timestamp) 存储给定时间戳 timestamp 时的键 key 和值 value。
//String get(String key, int timestamp) 返回一个值，该值在之前调用了 set，其中 timestamp_prev <= timestamp 。如果有多个这样的值，它将返回与最大  timestamp_prev 关联的值。如果没有值，则返回空字符串（""）。
public class TimeMap {
    private Map<String, List<Pair>> map;

    //官方解法：Map套一个list
    //查找的时候用二分法快速定位
    class Pair {
        String key;
        String value;
        int t;

        Pair(String k, String value, int t) {
            this.key = k;
            this.value = value;
            this.t = t;
        }
    }

    public TimeMap() {
        map = new HashMap<>();
    }


    public void set(String key, String value, int timestamp) {
        List<Pair> list = map.getOrDefault(key, new ArrayList<Pair>());
        list.add(new Pair(key, value, timestamp));
        map.put(key, list);

    }

    public String get(String key, int timestamp) {
        List<Pair> list = map.getOrDefault(key, new ArrayList<>());
        if (list.isEmpty()) {
            return "";
        }
        int n = list.size();
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid).t <= timestamp) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return list.get(right).t <= timestamp? list.get(right).value:"";
    }

}
