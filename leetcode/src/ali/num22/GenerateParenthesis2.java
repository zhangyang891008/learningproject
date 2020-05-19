package ali.num22;

import java.util.ArrayList;
import java.util.Arrays;
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
public class GenerateParenthesis2 {
    /**
     * 解法二：递归法
     */

    static ArrayList<String>[] res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList[n+1];

        generate(n);
        return res[n];
    }

    private List<String> generate(int n) {
        //如果是已经计算过，直接返回
        if(res[n] !=null){
            return res[n];
        }

        ArrayList<String> ans = new ArrayList<>();

        if(n==0){
            ans.add("");
        }else{
            for (int i = 0; i < n; i++) {
                for (String left : generate(i)) {
                    for (String right : generate(n - 1 - i)) {
                        ans.add("("+left+")"+right);
                    }
                }
            }
        }

        res[n] =  ans;

        return ans;
    }


    public static void main(String[] args) {

        int n = 3;
        List<String> res = new GenerateParenthesis2().generateParenthesis(n);
        for (String re : res) {
            System.out.println(re);
        }
    }
}
