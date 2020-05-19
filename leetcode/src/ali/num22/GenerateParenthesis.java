package ali.num22;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
22. 括号生成

数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
示例：

输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]
 */
public class GenerateParenthesis {
    /**
     * 解法一：回溯法
     */

    static List<String> res =  new ArrayList<>();;

    public List<String> generateParenthesis(int n) {
        res.clear();
        if(n<=0) {
            res.add("");
            return res;
        }
        gen(n-1,n, "(");

        return res;
    }

    private void gen(int left, int right, String s) {
        //减分支
        if(left<0 || right<0 ||left>right)
            return ;
        //如果字符用光，判断生成的字符串是否括号匹配，如果匹配就添加到结果集中
        if(left == 0 && right == 0 && isParenthesis(s)){
            res.add(s);
            return ;
        }
        gen(left-1,right,s+"(");
        gen(left,right-1,s+")");

    }

    //判断是否为匹配的括号
    private boolean isParenthesis(String s){
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while(index<s.length()){
            char c = s.charAt(index);
            if(c == '('){
                stack.push(c);
            }else{
                //出栈先判空
                if(stack.isEmpty()){
                    return false;
                }
                //判断出栈字符是否正确
                char pop = stack.pop();
                if(pop != '('){
                    return false;
                }
            }
            index++;
        }

        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }

    }


    public static void main(String[] args) {

        String s = "((()))";
        boolean parenthesis = new GenerateParenthesis().isParenthesis(s);
        System.out.println(parenthesis);


        int n = 3;
        List<String> res = new GenerateParenthesis().generateParenthesis(n);
        for (String re : res) {
            System.out.println(re);
        }
    }
}
