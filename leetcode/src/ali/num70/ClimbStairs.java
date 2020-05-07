package ali.num70;

/*
70. 爬楼梯

假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶
示例 2：

输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶
 */
public class ClimbStairs {

    /*
    动态规划：floor[i] = floor[i-1] + floor[i-2];
     */
    public int climbStairs(int n) {
        int[] floors = new int[n+1];

        if(n == 1)
            return 1;
        if(n==2)
            return 2;

        floors[1] = 1;
        floors[2] = 2;
        for (int i = 3; i < n+1; i++) {
            floors[i] = floors[i-1] + floors[i-2];
        }

        return floors[n];
    }

    public static void main(String[] args) {
        int floor = 6;
        int i = new ClimbStairs().climbStairs(floor);
        System.out.println(i);
    }
}