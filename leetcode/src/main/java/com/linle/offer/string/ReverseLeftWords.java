package com.linle.offer.string;

/**
 * @author chendeli
 * @Description: 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/5/30 15:06
 */
public class ReverseLeftWords {
    public static String reverseLeftWords(String s, int n) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt( (i+n)%s.length() ));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "lrloseumgh";
        String s1 = reverseLeftWords(s,6);
        System.out.println(s1);
    }


}
