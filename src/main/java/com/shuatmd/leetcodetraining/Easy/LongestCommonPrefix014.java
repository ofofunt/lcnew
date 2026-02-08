package com.shuatmd.leetcodetraining.Easy;

import java.util.Arrays;

public class LongestCommonPrefix014 {
    //简单解法：对整体array进行字典排序，然后将第一位与最后一位进行位比对
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int length = Math.min(strs[0].length(), strs[strs.length - 1].length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (strs[0].charAt(i) == strs[strs.length - 1].charAt(i)) {
                sb.append(strs[0].charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }

    //普通解法：纵向排查
    public String longestCommonPrefixNormal(String[] strs) {
        int length = strs[0].length();
        for (int i = 0; i < length; i++) {
            char curr = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || curr != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
