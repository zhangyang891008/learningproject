package ali.num300;

/*
300. 最长上升子序列

给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];

        dp[0] = 1;
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = i-1; j >=0 ; j--) {
                dp[i] = Math.max( nums[j] < nums[i] ? dp[j]+1:1, dp[i] );
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        int i = new LengthOfLIS().lengthOfLIS(arr);
        System.out.println(i);
    }
}
