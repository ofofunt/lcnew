package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//17. 电话号码的字母组合
//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
public class PhoneKeyBoardCombination017 {
    public static void main(String[] args) {
        PhoneKeyBoardCombination017 test = new PhoneKeyBoardCombination017();
        test.letterCombinations("23");
    }
    //手搓解法： 一眼回溯但是得考虑下
    List<String> combinationList;
    Map<Integer, String> map;

    public List<String> letterCombinations(String digits) {
        this.map = new HashMap<>();
        this.combinationList = new ArrayList<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        backlog(digits, 0, new StringBuilder());
        return combinationList;

    }

    private void backlog(String digits, int index, StringBuilder sb) {
        if (index == digits.length()) {
            combinationList.add(sb.toString());
            return;
        }
        int currDigit = digits.charAt(index) - '0';
        String values = map.get(currDigit);
        for (int i = 0; i < values.length(); i++) {
            sb.append(values.charAt(i));
            backlog(digits, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
