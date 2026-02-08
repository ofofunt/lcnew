package com.shuatmd.leetcodetraining.Medium;

public class WordDictionary {
    private WordDictionary[] children;
    private boolean isEnd;

    public WordDictionary() {
        children = new WordDictionary[26];
        isEnd = true;

    }

    public void addWord(String word) {
        WordDictionary node = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new WordDictionary();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        return search(this, word, 0);
    }

    private Boolean search(WordDictionary curr, String word, int start) {
        int n = word.length();
        if (start == n) {
            return curr.isEnd;
        }
        char c = word.charAt(start);
        //如果字母不为句号 则向下层搜索
        if (c != '.') {
            int index = c - 'a';
            WordDictionary item = curr.children[index];
            return item != null && search(item, word, start + 1);
        }
        //如果为句号 则需要遍历每个分支
        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null && search(curr.children[i], word, start + 1)) {
                return true;
            }

        }
        return false;

    }
}
