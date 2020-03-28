package com.no279;

/*
class Solution {

  public int numSquares(int n) {
    int dp[] = new int[n + 1];
    Arrays.fill(dp, Integer.MAX_VALUE);
    // bottom case
    dp[0] = 0;

    // pre-calculate the square numbers.
    int max_square_index = (int) Math.sqrt(n) + 1;
    int square_nums[] = new int[max_square_index];
    for (int i = 1; i < max_square_index; ++i) {
      square_nums[i] = i * i;
    }

    for (int i = 1; i <= n; ++i) {
      for (int s = 1; s < max_square_index; ++s) {
        if (i < square_nums[s])
          break;
        dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
      }
    }
    return dp[n];
  }
}
 */

/*
279. 完全平方数
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

示例 1:

输入: n = 12
输出: 3
解释: 12 = 4 + 4 + 4.
示例 2:

输入: n = 13
输出: 2
解释: 13 = 4 + 9.
 */
public class NumSquares {
    public int numSquares(int n) {
        //动态规划的方法，因为避免的重复计算，并且进行了减枝，比穷举法效率高
        int[] dp = new int[n+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;  //初始化设置为最大整数
        }
        dp[0] = 0;
        int max_square = (int)(Math.sqrt(n)+1);
        int[] squares = new int[max_square];  //预置好所有可能的平方数【1，4，9，16，。。。。】
        for (int i = 1; i < squares.length; i++) {
            squares[i] = i*i;
        }

        for (int i = 1; i <= n; i++) {
            for (int s = 1; s < max_square; s++) {
                if(i<squares[s])
                    break; //剪枝，一个数不可能小于它开根号后的数，平方数逐渐递增，如果当前平方数大于i，后面就不用再计算了
                dp[i] = Math.min(dp[i], dp[ i - squares[s]] + 1);  //逐渐刷新最小值
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        int i = new NumSquares().numSquares(12);
        System.out.println(i);
    }

}
