package ali.num09;

/*
9. 回文数

判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
进阶:

你能不将整数转为字符串来解决这个问题吗？
 */
public class IsPalindrome {

    /**
     * 不转换程字符串的解决方法：获取左右两侧的数字，进行比较
     * @param x
     * @return
     */

    public boolean isPalindrome(int x) {
        if(x == 0)
            return true;
        if(x < 0)
            return false;
        if(x > 0){
            int high = 1000000000;
            int low = 10;
            while(x/high == 0){
                high = high/10;
            }

            while(high >= low){
                int highVal = x/high %10; // %10是为了过滤掉更高位
                int lowVal = (x%low) /(low/10); //为了过滤掉更低位
                if(highVal != lowVal){
                    return false;
                }
                high = high/10;
                low = low*10;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean palindrome = new IsPalindrome().isPalindrome(1221);
        System.out.println(palindrome);
    }
}
