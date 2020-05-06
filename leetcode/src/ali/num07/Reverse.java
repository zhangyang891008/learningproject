package ali.num07;
/*
7. 整数反转

给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321
 示例 2:

输入: -123
输出: -321
示例 3:

输入: 120
输出: 21
注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Reverse {
    /*
    注意：需要考虑溢出问题
     */

    public int reverse(int x) {

        int reverse = 0;
        while(x!=0){
            int val = x%10;
            x = x /10;
            if(reverse > Integer.MAX_VALUE/10 || (reverse == Integer.MAX_VALUE/10 && val > 7)){    // 校验溢出 2147483647 ,-2147483648
                return 0;
            }
            if(reverse< Integer.MIN_VALUE/10 || (reverse == Integer.MIN_VALUE/10 && val < -8)){
                return 0;
            }
            reverse = reverse *10 + val;
        }

        return reverse;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        int reverse = new Reverse().reverse(-243);
        System.out.println(reverse);

    }
}
