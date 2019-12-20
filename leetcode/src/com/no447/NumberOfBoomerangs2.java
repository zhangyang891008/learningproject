package com.no447;

import java.util.HashMap;
import java.util.Map;

/*
447.回旋镖的数量
给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。

找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。

示例:

输入:
[[0,0],[1,0],[2,0]]

输出:
2

解释:
两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]

 */
public class NumberOfBoomerangs2 {
    public int numberOfBoomerangs(int[][] points) {

        if(points == null || points.length<3)
            return 0;
        Map<Integer,Integer> nodeDistances = new HashMap<>();
        int count  = 0;
        for (int i = 0; i < points.length; i++) {
            int curX = points[i][0];
            int curY = points[i][1];
            for (int j = 0; j < points.length; j++) {
                int loopX = points[j][0];
                int loopY = points[j][1];
                if(curX == loopX && curY == loopY){
                    continue;
                }
                int distance = (curX - loopX)*(curX - loopX) + (curY - loopY)*(curY - loopY); //System.out.println("loopNode("+loopX+","+loopY+")" + " Distance:"+distance);
                //nodeDistances.put(distance, nodeDistances.getOrDefault(distance,0)+1);
                if(nodeDistances.containsKey(distance)){
                    count += nodeDistances.get(distance) * 2;
                    nodeDistances.put(distance, nodeDistances.get(distance)+1);
                }else{
                    nodeDistances.put(distance, 1);
                }
            }
            nodeDistances.clear();
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = {{0,0},{1,0},{2,0}};
        //[[0,0],[1,0],[-1,0],[0,1],[0,-1]]
        int[][] points2 = {{0,0},{1,0},{-1,0},{0,1},{0,-1}};
        int i = new NumberOfBoomerangs2().numberOfBoomerangs(points2);
        System.out.println(i);
        System.out.println(points.length+"-"+points[0].length);
    }
}
