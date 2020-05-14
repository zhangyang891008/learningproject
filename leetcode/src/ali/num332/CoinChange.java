package ali.num332;

import java.util.Arrays;

/*
322. 零钱兑换

给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

示例 1:

输入: coins = [1, 2, 5], amount = 11
输出: 3
解释: 11 = 5 + 5 + 1
示例 2:

输入: coins = [2], amount = 3
输出: -1


说明:
你可以认为每种硬币的数量是无限的。
 */
public class CoinChange {

    /**
     * 解题：动态规划，f(目标金币数量) = Math.min( f(目标金币数量-币种1) ，..., f(目标金币数量-币种n)) +1   (1,表示前面选择了一种金币币种，计算一个金币)
     * @param coins
     * @param amount
     * @return
     */

    public int coinChange(int[] coins, int amount) {
        if(coins == null || coins.length==0)
            return -1;
        if(amount<0)
            return -1;
        if(amount == 0)
            return 0;

        int[] arr = new int[amount+1];
        arr[0] = 0;

        //一个金币的情况初始化设置一下，注意初始金币多余目标金币的情况下不要越界！！！
        for (int i = 0; i < coins.length; i++) {
            if( coins[i] <= amount){
                arr[coins[i]] = 1;
            }
            break;
        }
        for (int i = 1; i <= amount; i++) {
            if(arr[i] == 0){
                int temp = -1;
                for (int j = 0; j <coins.length; j++) {
                    //i-coins[j]是计算减去 coins[j]个金币以后，是不是成立，比如目标i是三个金币，coins[j] 是五金币，不够减就不成立了
                    //arr[i-coins[j]] >= 0 是判断减去coins[j]金币的情况下需要几个金币组合，如果不可达就是-1,要包括0的情况，因为f(0)是起点
                    if( i-coins[j] >=0 && arr[i-coins[j]] >= 0){
                        temp =  temp == -1? arr[i-coins[j]] : Math.min(temp, arr[i-coins[j]]);
                    }
                }

                arr[i] = temp==-1? temp:(temp+1);
            }
        }
        return arr[amount];
    }


    /**
     * 更精炼的写法
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        int max = amount+1;

        Arrays.fill(dp, max);

        dp[0] = 0;

        for (int i = 1; i < amount+1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if(i>=coins[j]){
                    dp[i] = Math.min(dp[i] , dp[i - coins[j]]+1);
                }
            }
        }
        return dp[amount] > amount ? -1:dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1,2};
        int amount  = 2;
        int i = new CoinChange().coinChange2(coins, amount);
        System.out.println(i);
    }
}
