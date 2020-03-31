package com.no207;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
207. 课程表
你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？

示例 1:

输入: 2, [[1,0]]
输出: true
解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
示例 2:

输入: 2, [[1,0],[0,1]]
输出: false
解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。

提示：

输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
你可以假定输入的先决条件中没有重复的边。
1 <= numCourses <= 10^5
 */

//========广度优先遍历========
public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];  //记录入度数
        List<List<Integer>> list = new ArrayList<>(); //存储节点之间的连接的关系
        Queue<Integer> queue = new ArrayDeque<>(); //入队的节点都是入度为0的节点

        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            indegrees[prerequisites[i][1]]++;  //有入度的节点统计入度
            list.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        //入度为0的先入队
        for (int i = 0; i < indegrees.length; i++) {
            if(indegrees[i]==0){
                queue.add(i);
            }
        }

        while(queue.size()>0){
            Integer cur = queue.remove();
            numCourses--;
            List<Integer> nodes = list.get(cur);  //判断后续的节点是不是入度为0，如果是就加入queue
            for (Integer node : nodes) {
                indegrees[node]--;
                if(indegrees[node]==0){
                    queue.add(node);
                }
            }
        }
        if(numCourses==0)
            return true;
        return false;
    }
    public static void main(String[] args) {

    }
}
