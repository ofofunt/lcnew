package com.shuatmd.leetcodetraining.Hard;
//30. 串联所有单词的子串
//给定一个字符串 s 和一个字符串数组 words。 words 中所有字符串 长度相同。
//
// s 中的 串联子串 是指一个包含  words 中所有字符串以任意顺序排列连接起来的子串。
//
//例如，如果 words = ["ab","cd","ef"]， 那么 "abcdef"， "abefcd"，"cdabef"， "cdefab"，"efabcd"， 和 "efcdab" 都是串联子串。 "acdbef" 不是串联子串，因为他不是任何 words 排列的连接。
//返回所有串联子串在 s 中的开始索引。你可以以 任意顺序 返回答案。

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubString030 {
    public static void main(String[] args) {
        FindSubString030 test = new FindSubString030();
        test.findSubstring("ababababab", new String[]{"ababa", "babab"});
    }
    //官方题解2：更符合我思路的解法 fori到wordLen 然后内部进行一个滑动窗口
    public List<Integer> findSubstringAdvanced(String s, String[] words) {
        int n = s.length(), m = words.length, w = words[0].length();
        // 统计 words 中「每个目标单词」的出现次数
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) map.put(str, map.getOrDefault(str, 0) + 1);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            // 构建一个当前子串对应的哈希表，统计当前子串中「每个目标单词」的出现次数
            Map<String, Integer> temp = new HashMap<>();
            // 滑动窗口的大小固定是 m * w，每次将下一个单词添加进 temp，上一个单词移出 temp
            for (int j = i; j + w <= n; j += w) {
                String cur = s.substring(j, j + w);
                temp.put(cur, temp.getOrDefault(cur, 0) + 1);
                if (j >= i + (m * w)) {
                    int idx = j - m * w;
                    String prev = s.substring(idx, idx + w);
                    if (temp.get(prev) == 1) temp.remove(prev);
                    else temp.put(prev, temp.get(prev) - 1);
                    if (!temp.getOrDefault(prev, 0).equals(map.getOrDefault(prev, 0))) continue;
                }
                if (!temp.getOrDefault(cur, 0).equals(map.getOrDefault(cur, 0))) continue;
                // 上面两个 continue 可以减少 map 之间的 equals 操作
                if (temp.equals(map)) ans.add(j - (m - 1) * w);
            }
        }
        return ans;
    }



    //官方解法：滑动窗口 + hashmap
    public List<Integer> findSubstringOfficial(String s, String[] words) {
        int wordLen = words[0].length();
        int winSize = words.length * wordLen;
        if (s.length() < winSize) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> wordMap = new HashMap<>();
        //构造一份基准词频表
        for (String word : words) {
            wordMap.compute(word, (k, v) -> v == null ? -1 : v - 1);
        }

        // 遍历wordLen个起始点，少了不够（xfoobar，光从起点 0 开始，匹配不到foobar）；但也不能多，多了就跟之前的周期重复了。
        for (int i = 0; i < wordLen; i++) {
            Map<String, Integer> currMap = new HashMap<>(wordMap);
            for (int right = i, left = i; right + wordLen <= s.length(); right += wordLen) {
                //推动右边界
                String word = s.substring(right, right + wordLen);
                //更新右边计数
                currMap.compute(word, (k, v) -> v == null ? 1 : v + 1);
                // 2. 如推进右界后，超频了，循环剔除左界元素，直到使得右界合规。窗口满不满无所谓，但里面一定不能有超频的词。
                while (left <= right && currMap.getOrDefault(word, 0) > 0) {
                    currMap.compute(s.substring(left, left + wordLen), (k, v) -> v - 1); // 左界词 -1
                    left += wordLen;
                }
                // 3. 窗口是满的，里面刚清完超频的词。这就是一个解。
                if (right - left + wordLen == winSize) {
                    list.add(left);
                }
            }
        }
        return list;
    }


    //手搓解法：滑动窗口 + hashmap鉴别
//可以修改的空间：判断太多 而且没必要 可以考虑在while的时候判断
//逻辑过于复杂
    public List<Integer> findSubstring(String s, String[] words) {
        //先根据单词的长度以及个数算好windows的size
        int wordLen = words[0].length();
        int windowLen = wordLen * words.length;
        if (s.length() < windowLen) {
            return new ArrayList<>();
        }
        List<Integer> resList = new ArrayList<>();
        Map<String, Integer> wordsCountMap = new HashMap<>();
        //可能存在相同的单词 所以需要getOrDefault
        for (String word : words) {
            wordsCountMap.put(word, wordsCountMap.getOrDefault(word, 0) + 1);
        }
        //初始化判断完毕之后开始进行固定窗口滑动
        //需要对wordLen做一个循环 不然会漏掉场景
        for (int j = 0; j < wordLen; j++) {
            //从初始状态开始计算
            int i = j;
            Map<String, Integer> sCountMap = new HashMap<>();
            while (i < windowLen) {
                if (i + wordLen > s.length()) {
                    break;
                }
                sCountMap.put(s.substring(i, i + wordLen),
                        sCountMap.getOrDefault(s.substring(i, i + wordLen), 0) + 1);
                i += wordLen;
            }
            if (sCountMap.equals(wordsCountMap)) {
                resList.add(j);
            }
            i = j;
            while (i < s.length() - windowLen) {
                //左移滑块部分，在map中删除之前的word
                //如果记录为1 则滑动的时候直接remove，否则-1
                if (sCountMap.get(s.substring(i, i + wordLen)) == 1) {
                    sCountMap.remove(s.substring(i, i + wordLen));
                } else {
                    sCountMap.put(s.substring(i, i + wordLen)
                            , sCountMap.get(s.substring(i, i + wordLen)) - 1);
                }
                //右移滑块部分,在map中添加新的word元素
                if (i + windowLen + wordLen > s.length()) {
                    break;
                }
                String nextWord = s.substring(i + windowLen, i + windowLen + wordLen);
                sCountMap.put(nextWord, sCountMap.getOrDefault(nextWord, 0) + 1);
                //滑完之后判断,如果相等 把结果放入list
                if (sCountMap.equals(wordsCountMap)) {
                    resList.add(i + wordLen);
                }
                i += wordLen;
            }
        }

        return resList;
    }
}
