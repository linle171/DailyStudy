package com.linle.offer.string;


import cn.hutool.core.util.StrUtil;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
class ReplaceSpace {
   static public String replaceSpaceTest(String s) {
        if(StrUtil.isEmpty(s)){
            return s;
        }
       String replace = s.replace(" ", "%20");
       return replace;
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        String s1 = replaceSpaceTest(s);
        System.out.println(s1);
    }
}