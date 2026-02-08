package com.shuatmd.leetcodetraining.Medium;

//208. 实现 Trie (前缀树)
//Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补全和拼写检查。
//
//请你实现 Trie 类：
//
//Trie() 初始化前缀树对象。
//void insert(String word) 向前缀树中插入字符串 word 。
//boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
//boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
public class Trie208 {
    //因为是树 所以要用嵌套构造函数
    private Trie208[] children;
    private boolean isEnd;

    public Trie208() {
        children = new Trie208[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie208 node = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie208();
            }
            node = node.children[index];
        }
        //对于最后一个字母节点 设置为结尾
        node.isEnd = true;


    }

    public boolean search(String word) {
        Trie208 node = searchPrefix(word);
        return node != null && node.isEnd;

    }

    private Trie208 searchPrefix(String word) {
        Trie208 node = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            //如果对应index的children存在值 则说明当前字典树存在这个char
            if (node.children[index] != null) {
                node = node.children[index];
            } else {
                return null;
            }

        }
        return node;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }
}
