package com.linle.exe.code2024.exec2401.exec240129;

import org.junit.Test;

import java.util.zip.CRC32;

/**
 * @description: 208. 实现 Trie (前缀树) middle
 * @author: chendeli
 * @date: 2024-01-29 20:17
 */
public class Trie {

    /**
     * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
     *
     * 请你实现 Trie 类：
     *
     * Trie() 初始化前缀树对象。
     * void insert(String word) 向前缀树中插入字符串 word 。
     * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
     * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
     *
     * 示例：
     *
     * 输入
     * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
     * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
     * 输出
     * [null, null, true, false, true, null, true]
     *
     * 解释
     * Trie trie = new Trie();
     * trie.insert("apple");
     * trie.search("apple");   // 返回 True
     * trie.search("app");     // 返回 False
     * trie.startsWith("app"); // 返回 True
     * trie.insert("app");
     * trie.search("app");     // 返回 True
     *
     * 提示：
     *
     * 1 <= word.length, prefix.length <= 2000
     * word 和 prefix 仅由小写英文字母组成
     * insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
     */
    @Test
    public void test(){
        TrieNode trieNode = new TrieNode();
        insert("apple");
        search("app");
        search("apple");
        startsWith("app");
        insert("app");
        search("app");
    }
    public Trie() {
        head = new TrieNode();
    }

    TrieNode head;

    class TrieNode{
        TrieNode[] curr;
        boolean isTail;
        TrieNode(){
            curr = new TrieNode[26];
        }

    }
    public void insert(String word) {
        TrieNode temp = head;
        int index = 0;
        int len = word.length();
        for (char c : word.toCharArray()) {
            TrieNode[] curr = temp.curr;
            if(curr[c-'a'] == null){
                curr[c-'a'] = new TrieNode();
            }
            if(index == len-1){
                curr[c-'a'].isTail = true;
            }
            temp = curr[c-'a'];
            index++;
        }
    }

    public boolean search(String word) {
        TrieNode temp = head;
        int index = 0;
        int len = word.length();
        for (char c : word.toCharArray()) {
            TrieNode[] curr = temp.curr;
            if(curr[c-'a'] == null){
                return false;
            }
            if(index == len-1 ){
               return curr[c-'a'].isTail;
            }
            temp =  curr[c-'a'];
            index++;
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        TrieNode temp = head;
        for (char c : prefix.toCharArray()) {
            TrieNode[] curr = temp.curr;
            if(curr[c-'a'] == null){
                return false;
            }
            temp =  curr[c-'a'];
        }
        return true;
    }
}
