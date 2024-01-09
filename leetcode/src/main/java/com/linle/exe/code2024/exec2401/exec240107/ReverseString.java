package com.linle.exe.code2024.exec240107;

import org.junit.Test;

/**
 * @description: 344. 反转字符串 simple
 * @author: chendeli
 * @date: 2024-01-07 23:32
 */
public class ReverseString {

    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
     *
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s = ["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     * 示例 2：
     *
     * 输入：s = ["H","a","n","n","a","h"]
     * 输出：["h","a","n","n","a","H"]
     *
     *
     * 提示：
     *
     * 1 <= s.length <= 105
     * s[i] 都是 ASCII 码表中的可打印字符
     */
    @Test
    public void test() {
        char[] s = new char[]{'h','e','l','l','o'};
        reverseString(s);
    }

    /**
     * 解题思路：递归解决（栈太深） 反转的字符串和原来的对称，使用双指针值交换就行
     * @param s
     */
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length-1;
        char temp;
        while(l < r){
            temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
