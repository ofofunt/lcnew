package com.shuatmd.leetcodetraining.Medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//139. 单词拆分
//给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
//
//注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
public class WordBreak139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        //用set来更方便的判断是否contains O(1)
        Set<String> dictionarySet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()];
        dp[0] = true;
        //将整段文字从i分割
        //如果dp[j] 为true 说明前半段部分是合法的
        //如果dictionarySet.contains(s.substring(j, i)则说明当前拆分之后的后半段也是合法存在的
        //满足两个条件则说明dp[i]是可以由字典中的词完美凭拼接的
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dictionarySet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
