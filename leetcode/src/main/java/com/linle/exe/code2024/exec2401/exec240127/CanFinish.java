package com.linle.exe.code2024.exec2401.exec240127;

import com.google.errorprone.annotations.Var;
import org.junit.Test;

import java.util.*;

/**
 * @description: 207. 课程表 middle
 * @author: chendeli
 * @date: 2024-01-26 20:34
 */
public class CanFinish {
    /**
     * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
     *
     * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
     *
     * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
     * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
     *
     * 示例 1：
     *
     * 输入：numCourses = 2, prerequisites = [[1,0]]
     * 输出：true
     * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
     * 示例 2：
     *
     * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
     * 输出：false
     * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
     *
     * 提示：
     *
     * 1 <= numCourses <= 2000
     * 0 <= prerequisites.length <= 5000
     * prerequisites[i].length == 2
     * 0 <= ai, bi < numCourses
     * prerequisites[i] 中的所有课程对 互不相同
     */
    @Test
     public void test(){
        canFinish(2,new int[][]{{1,0},{0,1}});
//        canFinish(3,new int[][]{{1,0},{0,2},{2,1}});
    }

    /**
     *
     * 解题思路：
     * @param numCourses
     * @param prerequisites
     * @return
     */
    int[] visitor;
    boolean isFlag = true;
    Map<Integer, Set<Integer>> map ;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map = new HashMap<>(numCourses);
        visitor = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            Set<Integer> set = map.getOrDefault(prerequisites[i][0], new HashSet<>());
            set.add(prerequisites[i][1]);
            map.put(prerequisites[i][0],set);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            if(visitor[i] == 0){
                check(i);
            }
        }
        return isFlag;



    }

    private void check(int i) {
        visitor[i] = 1;
        Set<Integer> b = map.getOrDefault(i,new HashSet<>());
        for (Integer next : b) {
            if(visitor[next] == 0){
                check(next);
                if(!isFlag){
                    return;
                }
            }else if(visitor[next] == 1){
                isFlag = false;
                return;
            }
        }
        visitor[i] = 2;
    }
}
