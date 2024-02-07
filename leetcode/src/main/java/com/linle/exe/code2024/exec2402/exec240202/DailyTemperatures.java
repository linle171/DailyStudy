package com.linle.exe.code2024.exec2402.exec240202;

import org.junit.Test;

import java.util.Stack;

/**
 * @description: 739. 每日温度 middle
 * @author: chendeli
 * @date: 2024-02-02 16:09
 */
public class DailyTemperatures {
    /**
     * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     *
     * 示例 1:
     *
     * 输入: temperatures = [73,74,75,71,69,72,76,73]
     * 输出: [1,1,4,2,1,1,0,0]
     * 示例 2:
     *
     * 输入: temperatures = [30,40,50,60]
     * 输出: [1,1,1,0]
     * 示例 3:
     *
     * 输入: temperatures = [30,60,90]
     * 输出: [1,1,0]
     *
     *
     * 提示：
     *
     * 1 <= temperatures.length <= 105
     * 30 <= temperatures[i] <= 100
     */
    @Test
    public void test(){
        dailyTemperatures(new int[]{30,40,50,60});
    }


    public int[] dailyTemperatures(int[] temperatures) {
        int[] count = new int[temperatures.length];
        Stack<Integer> sk = new Stack<>();
        sk.push(0);

        for (int i = 1; i < temperatures.length; i++) {
            while(!sk.isEmpty()){
                Integer peek = sk.peek();
                if(temperatures[i] <= temperatures[peek]){
                    sk.push(i);
                    break;
                }else {
                    sk.pop();
                    count[peek] = i-peek;
                }
            }
            if(sk.isEmpty()){
                sk.push(i);
            }
        }
        while(!sk.isEmpty()){
            Integer pop = sk.pop();
            count[pop] = 0;
        }
        return count;
    }
    public int[] dailyTemperatures1(int[] temperatures) {
        int n = temperatures.length;
        int[] arr = new int[temperatures.length];
        for(int i=n-2;i>=0;i--){//从后往前遍历
            for(int j=i+1;j<n;j+=arr[j]){ //跳跃arr[j]步
                if(temperatures[j] > temperatures[i]){
                    arr[i] = j-i;
                    break;
                }else if(arr[j] == 0){
                    arr[i] = 0;
                    break;
                }
            }
        }
        return arr;
    }
}
