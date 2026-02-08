package com.shuatmd.leetcodetraining.Medium;

import java.util.*;

//49. 字母异位词分组
//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
public class CheckGroupAnagrams049 {
    //官方解法1：用HashMap来存储 key为唯一标识 value为一个分好组的list
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> resMap = new HashMap<>();
        for (String str : strs) {
            char[] cur = str.toCharArray();
            Arrays.sort(cur);
            String key = new String(cur);
            List<String> curList = resMap.getOrDefault(key, new ArrayList<String>());
            //记得list中需要加入str而不是排序过得string
            curList.add(str);
            resMap.put(key, curList);
        }
        return new ArrayList<List<String>>(resMap.values());
    }
}
