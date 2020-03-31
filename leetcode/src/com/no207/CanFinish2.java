package com.no207;

import java.util.ArrayList;
import java.util.List;


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

//========深度优先遍历========
public class CanFinish2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] visit  = new int[numCourses];
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] arr : prerequisites) {
            list.get(arr[1]).add(arr[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if(!dfs(list,visit,i))
                return false;
        }
        return true;
    }

    private boolean dfs(List<List<Integer>> list, int[] visit, int i) {
        if(visit[i]==-1) return true;  //-1表示之前已经访问过了，1表示当前这次遍历遍历过，也就是形成了环
        if(visit[i]==1) return false;

        visit[i] = 1;  //标识为正在访问
        for (Integer j : list.get(i)) {
            if(!dfs(list,visit,j))return false;
        }
        visit[i] = -1;  //遍历结束，设置为访问过-1
        return true;
    }


    public static void main(String[] args) {
        int[][] arr = {{1,0}};
        int num = 2;
        boolean b = new CanFinish2().canFinish(num, arr);
        System.out.println(b);
    }
}
