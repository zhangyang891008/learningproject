package com.no406;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*

406. 根据身高重建队列
假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。

注意：
总人数少于1100人。

示例

输入:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

输出:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

 */
public class ConstructQueue {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b)-> a[0] == b[0] ? a[1] - b[1] : (b[0]-a[0]));
        List<int[]> ret = new ArrayList<>();
        for(int[] p : people){
            ret.add(p[1],p);
        }

        return ret.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] ints = new ConstructQueue().reconstructQueue(people);

        System.out.println(ints);
    }
}
