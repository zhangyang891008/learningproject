package ali.num394;

import java.util.Stack;

/*
394. 字符串解码
给定一个经过编码的字符串，返回它解码后的字符串。
编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

示例:

s = "3[a]2[bc]", 返回 "aaabcbc".
s = "3[a2[c]]", 返回 "accaccacc".
s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 */
public class DecodeString {

    /**
     * 辅助栈法：通过栈保存字符，当遇到右括号时，出栈字符、左括号、数字，然后根据数字拼接字符串再次入栈。
     * 当遍历到入参字符串的末尾以后，出栈字符组成字符串再反转。
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        int pos = 0; //记录访问到字符串s的索引位置

        while(pos<=s.length()-1){
            if(pos <= s.length() -1  && s.charAt(pos) != ']'){ //如果当前位置的字符不是右括号，入栈
                stack.push(s.charAt(pos));
                pos++;
            }else{  //找到右括号，就出栈字符、左括号、数字，按照数字的次数拼接字符串然后再次入栈
                String cur = "";
                while(stack.peek()!='['){  //出栈字符
                    cur = stack.pop()+cur;
                }
                stack.pop(); //出栈左括号
                StringBuilder number = new StringBuilder();
                //出栈数字,有可能有多位
                while(!stack.isEmpty() && stack.peek()>='0' && stack.peek()<='9'){
                    number.append(stack.pop());
                }
               // System.out.println(number.reverse().toString());
                int count = Integer.valueOf(number.reverse().toString());

                StringBuilder stringBuilder = new StringBuilder();
                while(count>0){  //把拼接的字符串按照出栈的数字次数再次入栈
                    for (int i = 0; i < cur.length(); i++) {
                        stack.push(cur.charAt(i));
                    }
                    count--;
                }
                pos++;  //跳过字符串的右中括号，遍历下一个字符
            }
        }

        //出栈所有字符串，反转字符串并返回结果
        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.reverse().toString();

    }

    public static void main(String[] args) {
        String a = "100[leetcode]";
        String s = new DecodeString().decodeString(a);
        System.out.println(s);
    }
}
