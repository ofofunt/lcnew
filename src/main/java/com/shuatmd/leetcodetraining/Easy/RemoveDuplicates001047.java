package com.shuatmd.leetcodetraining.Easy;

import java.util.Deque;
import java.util.LinkedList;

//1047. 删除字符串中的所有相邻重复项
//给出由小写字母组成的字符串 s，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
//
//在 s 上反复执行重复项删除操作，直到无法继续删除。
//
//在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
public class RemoveDuplicates001047 {
    public static void main(String[] args) {
        RemoveDuplicates001047 test = new RemoveDuplicates001047();
        test.removeDuplicates("abbaca");
    }
    //官方解法：用StringBuffer模拟栈
    public String removeDuplicatesOfficial(String s) {
        StringBuffer sb = new StringBuffer();
        int cur = -1;
        for (int i = 0; i < s.length(); i++) {
            if(cur >= 0 && s.charAt(i) == sb.charAt(cur)){
                sb.deleteCharAt(cur);
                cur--;
            }
            else{
                sb.append(s.charAt(i));
                cur++;
            }
        }
        return sb.toString();
    }
    //手搓解法：双端队列
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if(!stack.isEmpty()&&c == stack.peek()){
                stack.pop();
            }
            else {
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.removeLast());
        }

        return sb.toString();

    }
}
