package ali.num20;

import java.util.Stack;

/*
20. 有效的括号

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true
 */
public class IsValid {
    public boolean isValid(String s) {
        if(s== null || s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<>();

        int index = -1;
        while(index<s.length()-1){
            index++;
            char c = s.charAt(index);
            if(c=='{' || c=='[' || c == '('){
                stack.push(c);
            }else{
                if(stack.isEmpty())
                    return false;
                char pop = stack.pop();
                if((pop == '{' && c=='}') || (pop == '[' && c==']') ||
                        (pop == '(' && c==')')){
                    continue;
                }else{
                    return false;
                }
            }
        }

        if(stack.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

    }
}
