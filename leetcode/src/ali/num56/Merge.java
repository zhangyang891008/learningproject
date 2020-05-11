package ali.num56;


import java.util.*;

/*
56. 合并区间

给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Merge {

    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            int[][] arr = new int[0][0];
            return arr;
        }

        //1.先排序
        for (int i = 0; i < intervals.length-1; i++) {
            for (int j = i+1; j < intervals.length; j++) {
                if( intervals[i][0] > intervals[j][0]){
                    //交换
                    swap(intervals, i,j);
                }

                else if( (intervals[i][0] == intervals[j][0]) && (intervals[i][1] > intervals[j][1]) ){
                    //交换
                    swap(intervals, i,j);
                }

            }
        }

        List<Integer[]> ret = new LinkedList<>();

        int left = intervals[0][0];
        int right = intervals[0][1];
        //2.合并
        for (int index = 0; index < intervals.length; index++) {
            if(right < intervals[index][0]){
                //没有交集
                Integer[] curArr = {left, right};
                ret.add(curArr);

                left = intervals[index][0];
                right =  intervals[index][1];
            }else {
                left = Math.min(left, intervals[index][0]);
                right =  Math.max(right, intervals[index][1]);
            }
        }

        //最后一个结果添加到结果集合中
        Integer[] curArr = {left, right};
        ret.add(curArr);


        int[][] retArray = new int[ret.size()][2];

        for (int i = 0; i < ret.size(); i++) {
            retArray[i][0] = ret.get(i)[0];
            retArray[i][1] = ret.get(i)[1];
        }
        return retArray;
    }


    public void swap(int[][] arr, int i, int j){
        int temp_x = arr[i][0];
        int temp_y =  arr[i][1];

        arr[i][0] = arr[j][0];
        arr[i][1] = arr[j][1];

        arr[j][0] = temp_x;
        arr[j][1] = temp_y;

    }

    public static void main(String[] args) {
        int[][] arr = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        //int[][] arr = {{1,3}};
        int[][] merge = new Merge().merge(arr);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(merge[i][0]+","+ merge[i][1]);
        }
    }
}
