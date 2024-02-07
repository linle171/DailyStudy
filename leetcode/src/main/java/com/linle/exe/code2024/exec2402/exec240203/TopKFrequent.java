package com.linle.exe.code2024.exec2402.exec240203;

import lombok.Data;
import org.junit.Test;

import java.util.*;

/**
 * @description: 347. 前 K 个高频元素 middle
 * @author: chendeli
 * @date: 2024-02-03 12:56
 */
public class TopKFrequent {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
     *
     * 示例 1:
     *
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * 示例 2:
     *
     * 输入: nums = [1], k = 1
     * 输出: [1]
     *
     * 提示：
     *
     * 1 <= nums.length <= 105
     * k 的取值范围是 [1, 数组中不相同的元素的个数]
     * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
     *
     * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
     */
    @Test
    public void test(){
        topKFrequent(new int[]{4,1,-1,2,-1,2,3},2);
    }

    /**
     *
     * 解题思路：
     * @param nums
     * @param k
     * @return
     */

    public int[] topKFrequent(int[] nums, int k) {
        int[] temp = new int[k];
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        //先统计每个数出现的次数
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0) + 1);
        }
        Queue<Node> queue = new PriorityQueue<>(k, Comparator.comparing(Node::getCount));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            if(queue.size() == k){
                if( queue.peek().count < entry.getValue()){
                    queue.poll();
                    queue.add(node);
                }
            }else {
                queue.add(node);
            }
        }
        int i = 0;
        for (Node node : queue) {
            temp[i++] = node.value;
        }

        return temp;
    }

    class Node{
        Integer value;
        Integer count;
        Node(Integer value,Integer count){
            this.value = value;
            this.count = count;
        }
        Integer getCount(){
            return count;
        }
    }


    public int[] topKFrequent1(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i : nums) {
            if(i > max) {
                max = i;
            }
            if(i < min) {
                min = i;
            }
        }
        if (max == min) return new int[]{nums[0]};
        int[] map = new int[max - min + 1];
        for(int i : nums) {
            map[i - min]++;
        }
        ArrayList<Integer>[] count = new ArrayList[nums.length];
        for(int i = 0; i < map.length; i++) {
            if(map[i] > 0) {
                if(count[map[i]] == null) {
                    count[map[i]] = new ArrayList();
                }
                count[map[i]].add(i + min);
            }
        }
        int res[] = new int[k];
        for(int i = count.length - 1, j = 0; i >= 0 && j < k; i--) {
            if(count[i] != null) {
                while(!count[i].isEmpty()) {
                    res[j++] = count[i].remove(count[i].size() - 1);
                }
            }
        }

        return res;
    }
}
