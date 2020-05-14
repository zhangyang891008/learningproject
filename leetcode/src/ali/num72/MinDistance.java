package ali.num72;

import java.util.Map;

/*
72. 编辑距离

给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。

你可以对一个单词进行如下三种操作：

插入一个字符
删除一个字符
替换一个字符

示例 1：

输入：word1 = "horse", word2 = "ros"
输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')
示例 2：

输入：word1 = "intention", word2 = "execution"
输出：5
解释：
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')
 */
public class MinDistance {
    /**
     * 动态规划：每增加一个字符、减少一个字符、修改一个字符的代价都是一次操作。
     *
     * @param word1
     * @param word2
     * @return
     */

    public int minDistance(String word1, String word2) {
        if(word1==null && word2 == null)
            return 0;
        if(word1 == null){
            word2.length();
        }
        if(word2 == null){
            word1.length();
        }

        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n+1][m+1];

        //只有字符串1的情况
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = i;
        }
        //只有字符串2的情况
        for (int i = 0; i < m+1; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                int left = dp[i-1][j] +1;  //增加字符串必然会增加操作次数1次
                int  up =  dp[i][j-1] +1;  //增加字符串必然会增加操作次数1次
                //两个字符换都增加一个字符，如果是相同字符不增加次数，如果是不同字符就是一次替换操作
                int corner = dp[i-1][j-1] + (word1.charAt(i-1) == word2.charAt(j-1) ? 0:1);

                dp[i][j] = Math.min(corner, Math.min(left, up));
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "es";
        int i = new MinDistance().minDistance(word1, word2);
        System.out.println(i);
    }
}
