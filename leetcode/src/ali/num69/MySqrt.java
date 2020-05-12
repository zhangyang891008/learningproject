package ali.num69;

/*
69. x 的平方根
 
实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:

输入: 4
输出: 2
示例 2:

输入: 8
输出: 2
说明: 8 的平方根是 2.82842...,
     由于返回类型是整数，小数部分将被舍去。
 */
public class MySqrt {

    public int mySqrt(int x) {
        if(x==0)
            return 0;
        int left = 0;
        int right = x;

        int ans = -1;

        while( left <=right){
            int mid = (left + right)/2;
            if((long)mid*mid <= x){  //需要强制转换，否则会溢出!!!
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int i = new MySqrt().mySqrt(24);
        System.out.println(i);
    }
}
