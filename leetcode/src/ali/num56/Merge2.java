package ali.num56;

import java.util.Arrays;

public class Merge2 {

    /*

    Leetcode中的优秀答案：排序、合并、拷贝数组
     */

    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            int[][] arr = new int[0][0];
            return arr;
        }

        Arrays.sort(intervals, (v1,v2)->v1[0] - v2[0]);

        int[][] ret = new int[intervals.length][intervals[0].length];

        int index = -1; //表示目前还没有元素添加到结果集合中
        for (int[] interval : intervals) {
            if(index == -1 || ret[index][1] < interval[0]){
                ret[++index] = interval;
            }else{
                ret[index][1] = Math.max(interval[1], ret[index][1]);
            }
        }

        return Arrays.copyOf(ret, index+1);
    }



    public static void main(String[] args) {
        int[][] arr = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        //int[][] arr = {{1,3}};
        int[][] merge = new Merge2().merge(arr);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(merge[i][0]+","+ merge[i][1]);
        }
    }
}
