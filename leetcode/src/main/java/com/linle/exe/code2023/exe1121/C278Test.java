package com.linle.exe.code2023.exe1121;

import org.junit.Test;

/**
 * @author chendeli
 * @Description: 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
 * 由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。
 * 实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * @date 2022/11/21 11:25
 */
public class C278Test {
    /**
     * 示例 1：
     * <p>
     * 输入：n = 5, bad = 4
     * 输出：4
     * 解释：
     * 调用 isBadVersion(3) -> false
     * 调用 isBadVersion(5) -> true
     * 调用 isBadVersion(4) -> true
     * 所以，4 是第一个错误的版本。
     * 示例 2：
     * <p>
     * 输入：n = 1, bad = 1
     * 输出：1
     *  
     * <p>
     * 提示：
     * <p>
     * 1 <= bad <= n <= 231 - 1
     */
    @Test
    public void test278() {
        int n = 10;
        if (n == 1 || isBadVersion(1)) {
            return;
        }
        int left = 1;
        int right = 2126753390;
        while (left < right) {
            int preMiddle = left + (right - left) / 2;
            //结束条件，若是中间值为left，说明目前就两个值，昨天是正确的版本，右边则为错误的版本
            if (preMiddle == left) {
                System.out.println(right);
                return;
            }
            if (isBadVersion(preMiddle)) {
                right = preMiddle;
            } else {
                left = preMiddle;
            }
        }
    }

    boolean isBadVersion(int version) {
        if (version < 1702766719) {
            return false;
        }
        return true;
    }
}
