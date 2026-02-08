package com.shuatmd.leetcodetraining.Medium;

public class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        this.children = new Trie[26];
        isEnd = true;

    }

    public void insert(String word) {
        Trie node = this;
        char[] chars = word.toCharArray();
        for (char a : chars) {
            int index = a -'a';
            if(node.children[index]==null){
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        //添加完之后要设置结尾
        node.isEnd = true;

    }

    public boolean search(String word) {
        Trie node = prefixSearch(word);
        return node!=null && node.isEnd;

    }

    private Trie prefixSearch(String word) {
        Trie node = this;
        char[] chars = word.toCharArray();
        for (char a : chars) {
            int index = a - 'a';
            if(node.children[index] != null){
                node = node.children[index];
            }
            else{
                return null;
            }
        }
        return node;
    }

    public boolean startsWith(String prefix) {
        return prefixSearch(prefix)!=null;

    }
}
