package com.linle.str;

import org.junit.Test;


/**
 * @description:
 * @author: chendeli
 * @date: 2024-01-03 10:40
 */
public class KMPAlgorithm {
    /**
     * abaaba
     *
     */
    @Test
    void KMPImpl(){
        String mainStr = "ababatre";
        String patternStr = "abacd";
        int[] next = getNext(patternStr);
        int j = 0;
        for (int i = 0; i <mainStr.length(); i++) {
            while(j>0 && mainStr.charAt(i) != patternStr.charAt(j)){
                j = next[j-1] + 1;
            }
            if(mainStr.charAt(i) == patternStr.charAt(j)){
                j++;
            }
            if(j == patternStr.length()-1){
                System.out.println(i - j +1);
                return ;
            }
        }

    }

    /**
     * 获取模式串的next数组（好前缀）
     * @param s
     * @return
     */
    private int[] getNext(String s) {
        int[] next = new int[s.length() +1];
        next[0] = -1;
        int f = -1;
        for (int i = 1; i < next.length; i++) {
            while( f != -1 && next[i] != next[f+1]){
                f = next[i];
            }
            if(next[i] == next[f+1]){
               f++;
            }
            next[i] = f;
        }
        return next;
    }
}
