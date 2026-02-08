package com.shuatmd.leetcodetraining.Medium;
//12. 整数转罗马数字
public class IntegerToRoman012 {
    public static void main(String[] args) {
        IntegerToRoman012 roman = new IntegerToRoman012();
        roman.intToRoman(3749);
    }
    //手搓解法
    //贪心算法：从最高的数字开始减 减不动则挪一位
    //把所有可能得组合结果放入array中
    public String intToRoman(int num) {
        int[] valueArray = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] strs = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int target = num;
        int index = 0;
        StringBuffer sb = new StringBuffer();
        while (target > 0) {
            if (target - valueArray[index] >= 0) {
                target = target - valueArray[index];
                sb.append(strs[index]);
                continue;
            }
            index++;
        }
        return sb.toString();
    }
}
