package com.linle.exe.code2023.exec1217;

import org.junit.Test;

/**
 * @author chendeli
 * @Description: 无重复字符的最长子串
 * @date 2022/12/16 10:14
 */
public class C3Test {


    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 提示：
     *
     * 0 <= s.length <= 5 * 104
     * s 由英文字母、数字、符号和空格组成
     */
    @Test
    public void test3() {
        String s = "ssds";
        if(s.length() == 0 || s.length() == 1){
            return ;
        }
        int length = 1;
        int pre = 0,sub =1;
        char[] chars = s.toCharArray();
        for ( ;sub<s.length() ;sub++) {
            boolean isFlag = true;
            for (int k = pre; k < sub; k++) {
                if(chars[k] == chars[sub]){
                    pre = k + 1;
                    isFlag = false;
                    break;
                }
            }
            if(isFlag && sub-pre + 1>length){
                length = sub - pre + 1;
            }
        }
        System.out.println(length);

    }
}
