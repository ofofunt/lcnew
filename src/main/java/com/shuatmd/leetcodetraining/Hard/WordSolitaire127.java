package com.shuatmd.leetcodetraining.Hard;

import cn.hutool.core.lang.Pair;

import java.util.*;

//127. 单词接龙
//字典 wordList 中从单词 beginWord 到 endWord 的 转换序列 是一个按下述规格形成的序列 beginWord -> s1 -> s2 -> ... -> sk：
//
//每一对相邻的单词只差一个字母。
// 对于 1 <= i <= k 时，每个 si 都在 wordList 中。注意， beginWord 不需要在 wordList 中。
//sk == endWord
//给你两个单词 beginWord 和 endWord 和一个字典 wordList ，返回 从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0 。
public class WordSolitaire127 {
    //官方解法：bfs判断匹配
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //如果wordList中不存在endWord则不可能接龙成功
        if (!wordList.contains(endWord)) {
            return 0;
        }
        //预处理 用一个map来记录当前所有单词的可能匹配状态
        Map<String, List<String>> matchMap = new HashMap<>();
        for (String s : wordList) {
            for (int i = 0; i < s.length(); i++) {
                String curr = s.substring(0, i) + "*" + s.substring(i + 1);
                List<String> matchWords = matchMap.getOrDefault(curr, new ArrayList<>());
                matchWords.add(s);
                //注意为了通配需求 需要用curr来作为key而不是s作为key
                matchMap.put(curr, matchWords);
            }
        }

        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));
        //防止重复访问
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            Pair<String, Integer> poll = queue.poll();
            String currWord = poll.getKey();
            int level = poll.getValue();
            for (int i = 0; i < currWord.length(); i++) {
                String newWord = currWord.substring(0, i) + "*" + currWord.substring(i + 1);
                if (matchMap.containsKey(newWord)) {
                    List<String> strings = matchMap.get(newWord);
                    for (String s : strings) {
                        if (s.equals(endWord)) {
                            return level + 1;
                        }
                        if (!visited.contains(s)) {
                            queue.offer(new Pair<>(s, level + 1));
                            visited.add(s);
                        }
                    }

                }
            }
        }

        return 0;
    }
}
