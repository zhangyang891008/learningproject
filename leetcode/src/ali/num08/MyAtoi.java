package ali.num08;

/*
8. 字符串转换整数 (atoi)

请你来实现一个 atoi 函数，使其能将字符串转换成整数。

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：

    如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
    假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
    该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0 。

提示：

    本题中的空白字符只包括空格字符 ' ' 。
    假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。



示例 1:

输入: "42"
输出: 42

示例 2:

输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。

示例 3:

输入: "4193 with words"
输出: 4193
解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。

示例 4:

输入: "words and 987"
输出: 0
解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     因此无法执行有效的转换。

示例 5:

输入: "-91283472332"
输出: -2147483648
解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     因此返回 INT_MIN (−231) 。


 */
public class MyAtoi {
    public int myAtoi(String str) {
        //首先去空格
        if(str == null || str.trim().length() == 0)
            return 0;

        str = str.trim();

        boolean positive = true;
        int index = 0;
        int retNumber = 0;

        //1.首先拿第一个字符，判断是否是符号，如果是符号，保存其符号位
        if(str.charAt(0) == '-'){
            positive = false;
            index++;
        }
        if(str.charAt(0) == '+'){
            positive = true;
            index++;
        }

        //2.读取数字
        while(index<str.length()){
            if(isNumber(str.charAt(index))){
                int cur = Integer.valueOf(str.substring(index,index+1));
                cur = positive?cur:(0-cur)  ;//带符号
                //拼接数字
                if( positive ==true && (retNumber>Integer.MAX_VALUE/10 || (retNumber==Integer.MAX_VALUE/10 && cur>7)) ){
                    retNumber = Integer.MAX_VALUE;
                    break;
                }else if(positive == false && (retNumber<Integer.MIN_VALUE/10 || (retNumber==Integer.MIN_VALUE/10 && cur<-8))){
                    retNumber = Integer.MIN_VALUE;
                    break;
                }else{
                    retNumber = retNumber*10 + cur;
                }
                index++;
            }else{
                break;
            }
        }

        return retNumber;

    }

    private boolean isNumber(char ch) {
        if(ch>='0' && ch<='9'){
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        String s = "  2147483650 dd";
        int i = new MyAtoi().myAtoi(s);
        System.out.println(i);
    }
}
