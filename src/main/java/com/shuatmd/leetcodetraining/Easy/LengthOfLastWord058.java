package com.shuatmd.leetcodetraining.Easy;

//58. 最后一个单词的长度
public class LengthOfLastWord058 {
    public static void main(String[] args) {
        LengthOfLastWord058 lastWord = new LengthOfLastWord058();
        lastWord.lengthOfLastWord("Today is a nice day");
    }

    //官方解法：反向遍历
    public int lengthOfLastWordOfficial(String s) {
        int res = 0;
        int index = s.length() - 1;
        while (s.charAt(index) == ' ') {
            index--;
        }
        while (index >= 0 && s.charAt(index) != ' ') {
            res++;
            index--;
        }
        return res;
}

    //通过空格spilt 然后倒序查找第一个length大于0的部分
    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        for (int i = s1.length - 1; i >= 0; i--) {
            if (s1[i].length() > 0) {
                return s1[i].length();
            }
        }
        return -1;
    }
}
