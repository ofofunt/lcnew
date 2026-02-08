package com.shuatmd.leetcodetraining.Easy;

//67. 二进制求和
//给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
public class BinaryAdding067 {
    //直观做法：转成十进制，相加然后再换成二进制
    public String addBinary(String a, String b) {
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));

    }

    //官方解法2：模拟 从末尾开始轮流加 并且需要计算进位
    public String addBinaryMock(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            //如果i,j已经小于0 当前位置用0补上
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            sb.append(sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }
        sb.append(carry == 1 ? carry : "");
        //因为是倒序append所以还需要reverse一下

        return  sb.reverse().toString();
    }
}
