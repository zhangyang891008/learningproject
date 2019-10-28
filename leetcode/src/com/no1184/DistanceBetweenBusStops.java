package com.no1184;

/*
1184. 公交站间的距离
环形公交路线上有 n 个站，按次序从 0 到 n - 1 进行编号。我们已知每一对相邻公交站之间的距离，distance[i] 表示编号为 i 的车站和编号为 (i + 1) % n 的车站之间的距离。

环线上的公交车都可以按顺时针和逆时针的方向行驶。

返回乘客从出发点 start 到目的地 destination 之间的最短距离。

 输入：distance = [1,2,3,4], start = 0, destination = 1
输出：1
解释：公交站 0 和 1 之间的距离是 1 或 9，最小值是 1。
 输入：distance = [1,2,3,4], start = 0, destination = 2
输出：3
解释：公交站 0 和 2 之间的距离是 3 或 7，最小值是 3。


*********************
时间复杂度为O（N），空间复杂度为O（1）


 */
public class DistanceBetweenBusStops {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if(distance == null || distance.length==0 ||start == destination)
            return 0;
        int positiveDistance = 0;
        int negtiveDistance = 0;

        for (int i = start; i != destination ; i = (i+1)%distance.length) {
            positiveDistance += distance[i];
        }

        for (int i = destination; i != start ; i = (i+1)%distance.length) {
            negtiveDistance += distance[i];
        }

        return Math.min(positiveDistance, negtiveDistance);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int i = new DistanceBetweenBusStops().distanceBetweenBusStops(arr, 0, 1);
        System.out.println(i);
    }
}
