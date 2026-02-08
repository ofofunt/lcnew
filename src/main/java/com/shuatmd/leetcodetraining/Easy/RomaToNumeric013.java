package com.shuatmd.leetcodetraining.Easy;

import java.util.HashMap;
import java.util.Map;

//13. 罗马数字转整数
//例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
//
//通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
//
//I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
//X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
//C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
//给定一个罗马数字，将其转换成整数。
public class RomaToNumeric013 {
    //手写解法:一位一位遍历,如果后一位比前面大则减去前面部分,否则相加
    public int romanToInt(String s) {
        Map<Character,Integer> valueMap = new HashMap<>();
        valueMap.put('I',1);
        valueMap.put('V',5);
        valueMap.put('X',10);
        valueMap.put('L',50);
        valueMap.put('C',100);
        valueMap.put('D',500);
        valueMap.put('M',1000);
        int length = s.length();
        int res = 0;
        for (int left = 0; left < length - 1; left++) {
            int val = valueMap.get(s.charAt(left));
            if(val < valueMap.get(s.charAt(left + 1))){
                res = val - res;
            }
            else {
                res+=val;
            }
        }
        res+=valueMap.get(s.charAt(length - 1));
        return res;
    }
}
