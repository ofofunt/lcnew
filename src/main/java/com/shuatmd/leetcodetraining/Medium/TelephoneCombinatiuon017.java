package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//电话号码的字母组合
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
public class TelephoneCombinatiuon017 {
    public static void main(String[] args) {
        TelephoneCombinatiuon017 test = new TelephoneCombinatiuon017();
        test.letterCombinations("23");
    }
    //手搓解法1：尝试理解回溯
    public List<String> letterCombinations(String digits) {
        //先判断特殊情况
        if(digits.length() == 0){
            return new ArrayList<>();
        }
        Map<Integer,String> map = new HashMap<>();
        map.put(0,"");
        map.put(1,"");
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        List<String> combinations = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        recur(combinations,digits,0,sb,map);
        return combinations;

    }

    private void recur(List<String> combinations, String digits, int index, StringBuilder sb, Map<Integer, String> map) {
        //先考虑终止条件
        if(index == digits.length()){
            combinations.add(sb.toString());
        }
        else {
            int currDigit = digits.charAt(index) - '0';
            String curr = map.get(currDigit);
            int letterLength = curr.length();
            for (int i = 0; i < letterLength; i++) {
                sb.append(curr.charAt(i));
                recur(combinations, digits, index + 1, sb, map);
                sb.deleteCharAt(index);
            }
        }


    }
}
