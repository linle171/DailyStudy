package com.linle.exe.code2023.exec1221;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: chendeli
 * @date: 2023-12-21 09:54
 */
public class C120 {

    @Test
    public void test1() {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Lists.newArrayList(2));
        triangle.add(Lists.newArrayList(3, 4));
        triangle.add(Lists.newArrayList(6, 5, 7));
        triangle.add(Lists.newArrayList(4, 1, 8, 3));
        int size = triangle.size();
        int[][] minPaths = new int[2][size];
        minPaths[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            int curr = i % 2;
            int pre = 1 - curr;
            minPaths[curr][0] = minPaths[pre][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                minPaths[curr][j] = Math.min(minPaths[pre][j-1],minPaths[pre][j]) + triangle.get(i).get(j);
            }
            minPaths[curr][i] = minPaths[pre][i-1] + triangle.get(i).get(i);
        }
        int minTotal = minPaths[(size -1) % 2][0];
        for (int i = 1; i < size; i++) {
            minTotal = Math.min(minTotal, minPaths[(size -1) % 2][i]);
        }

    }


    @Test
    public void test2() {

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Lists.newArrayList(2));
        triangle.add(Lists.newArrayList(3, 4));
        triangle.add(Lists.newArrayList(6, 5, 7));
        triangle.add(Lists.newArrayList(4, 1, 8, 3));
        int size = triangle.size();
        int[] minPaths = new int[size];
        minPaths[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            minPaths[i] = minPaths[i-1] + triangle.get(i).get(i);
            for (int j = i-1; j >0; j--) {
                minPaths[j] = Math.min(minPaths[j-1],minPaths[j]) + triangle.get(i).get(j);
            }
            minPaths[0] = minPaths[0] + triangle.get(i).get(0);
        }
        int minTotal = minPaths[0];
        for (int i = 1; i < size; i++) {
            minTotal = Math.min(minTotal, minPaths[i]);
        }
        System.out.println(minTotal);
    }


    @Test
    public void test3() {

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Lists.newArrayList(2));
        triangle.add(Lists.newArrayList(3, 4));
        triangle.add(Lists.newArrayList(6, 5, 7));
        triangle.add(Lists.newArrayList(4, 1, 8, 3));
        triangle.add(Lists.newArrayList(6, 5, 7));
        triangle.add(Lists.newArrayList(3, 4));
        triangle.add(Lists.newArrayList(2));
        int size = triangle.size();
        int[] minPaths = new int[(size/2)+1];
        minPaths[0] = triangle.get(0).get(0);
        for (int i = 1; i < (size/2)+1; i++) {
            minPaths[i] = minPaths[i-1] + triangle.get(i).get(i);
            for (int j = i-1; j >0; j--) {
                minPaths[j] = Math.min(minPaths[j-1],minPaths[j]) + triangle.get(i).get(j);
            }
            minPaths[0] = minPaths[0] + triangle.get(i).get(0);
        }
        for (int i = (size/2)+1; i < size; i++) {
            for (int j = 0; j < (size-i) ; j++) {
                minPaths[j] = Math.min(minPaths[j],minPaths[j+1]) + triangle.get(i).get(j);
            }
        }

        System.out.println(minPaths[0]);
    }
}
