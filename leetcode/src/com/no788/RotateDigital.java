package com.no788;
/*
我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？

示例:
输入: 10
输出: 4
解释:
在[1, 10]中有四个好数： 2, 5, 6, 9。
注意 1 和 10 不是好数, 因为他们在旋转之后不变。
注意:

N 的取值范围是 [1, 10000]。
 */
public class RotateDigital {
    public int rotatedDigits(int N) {
        if(N<0)
            return 0;
        int count = 0;
        for (int i = 0; i <= N; i++) {
            String number = String.valueOf(i);
            if(number.contains("3")|| number.contains("4") || number.contains("7"))
                continue;
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < number.length(); j++) {
                if("0".equals(number.substring(j,j+1)))
                    s.append('0');
                if("1".equals(number.substring(j,j+1)))
                    s.append('1');
                if("2".equals(number.substring(j,j+1)))
                    s.append('5');
                if("5".equals(number.substring(j,j+1)))
                    s.append('2');
                if("6".equals(number.substring(j,j+1)))
                    s.append('9');
                if("8".equals(number.substring(j,j+1)))
                    s.append('8');
                if("9".equals(number.substring(j,j+1)))
                    s.append('6');
            }
            if(!s.toString().equals(number))
                count++;
        }
        return count;
    }

    public int rotatedDigits1(int N) {
        int count=0;

        for (int i = 0; i <= N; i++) {
            
        }

        return count;
    }

    public static void main(String[] args) {
        int N = 10;
        int i = new RotateDigital().rotatedDigits(N);
        System.out.println(i);
    }
}
