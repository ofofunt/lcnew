package com.shuatmd.leetcodetraining.Medium;
//38. 外观数列
//「外观数列」是一个数位字符串序列，由递归公式定义：
//
//countAndSay(1) = "1"
//countAndSay(n) 是 countAndSay(n-1) 的行程长度编码。
//
//
//行程长度编码（RLE）是一种字符串压缩方法，其工作原理是通过将连续相同字符（重复两次或更多次）替换为字符重复次数（运行长度）和字符的串联。例如，要压缩字符串 "3322251" ，我们将 "33" 用 "23" 替换，将 "222" 用 "32" 替换，将 "5" 用 "15" 替换并将 "1" 用 "11" 替换。因此压缩后字符串变为 "23321511"。
//
//给定一个整数 n ，返回 外观数列 的第 n 个元素。
public class CountParadeArray038 {
    public static void main(String[] args) {
        CountParadeArray038 test = new CountParadeArray038();
        test.countAndSay(6);
    }
    public String countAndSayOfficial(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int start = 0;
            int pos = 0;
            while(pos<str.length()){
                while(pos<str.length() && str.charAt(pos) == str.charAt(start)){
                    pos++;
                }
                sb.append(Integer.toString(pos - start)).append(str.charAt(start));
                start = pos;
            }
            str = sb.toString();
        }
        return str;
    }

    //手搓尝试1：暴力解法
    public String countAndSay(int n) {
        if(n == 0){
            return "0";
        }
        if(n == 1){
            return "1";
        }
        String init = "1";
        String cur = parseToCountArray(init);
        for (int i = 2; i < n; i++) {
            cur = parseToCountArray(cur);
        }
        return cur;
    }

    private String parseToCountArray(String str) {
        char[] chars = str.toCharArray();
        int count = 1;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length - 1; i++) {
            if(chars[i] == chars[i + 1]){
                count++;
            }
            else{
                sb.append(String.valueOf(count) + chars[i]);
                count = 1;
            }
        }
        sb.append(String.valueOf(count) + chars[chars.length-1]);
        return sb.toString();
    }
}
