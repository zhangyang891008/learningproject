package ali.num347;

import java.util.*;

/*
347. 前 K 个高频元素

给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]


提示：

你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
你可以按任意顺序返回答案。
 */
public class TopKFrequent {

    /**
     * 堆排序
     * @param nums
     * @param k
     * @return
     */

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> frequencies = new HashMap<>();
        //设置为小顶堆,因为要把出现频率低的元素移除
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1,n2)->frequencies.get(n1) - frequencies.get(n2));
        for (int num : nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0)+1);
        }

        for (Integer key : frequencies.keySet()) {
            queue.add(key);
            if(queue.size()>k){
                queue.poll();
            }
        }

        //把结果保存到数组并返回；
        int[] ret = new int[k];
        int index = 0;
        while(!queue.isEmpty()){
            ret[index++] = queue.poll();
        }

        return ret;
    }

    public static void main(String[] args) {

    }
}
