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
public class LengthOfLIS2 {
    /**
     * 动态规划+二分查找 dp[i] 记录了长度为i+1的递增字符串的最小结尾值。
     * 当一个值小于当前长度的递增字符串的最后一个字符，通过二分查找找到它应该替换的位置。
     * 为什么能替换？ 因为dp中存储的数字位置都是位于当前数字之前的
     *
     * 时间复杂度：O（N*logN）
     * 空间复杂度：O(N)
     * @param nums
     * @return
     */

    public int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length == 0)
            return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int end = 0;

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > dp[end]){
                dp[++end] = nums[i];
            }else{
                int left = 0;
                int right = end;
                while(left<right){
                    int mid = (left+right)/2;
                    if(dp[mid] < nums[i]){
                        left = mid+1;
                    }else{
                        right = mid;
                    }
                }

                dp[left] = nums[i];
            }
        }
        return ++end;
    }

    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        int i = new LengthOfLIS2().lengthOfLIS(arr);
        System.out.println(i);
    }
}
