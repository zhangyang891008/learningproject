package ali.num10;

/*
10. 正则表达式匹配
 d
给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "a*"
输出: true
解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
示例 3:

输入:
s = "ab"
p = ".*"
输出: true
解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
示例 4:

输入:
s = "aab"
p = "c*a*b"
输出: true
解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
示例 5:

输入:
s = "mississippi"
p = "mis*is*p*."
输出: false
 */
public class Ismatch {

    public boolean isMatch(String s, String p) {
        if(s == null || p == null)
            return false;

        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;

        //首行只有 a*b*c*d*这种情况下才是匹配 s=""的，其他情况都不能够匹配
        for (int k = 2; k <= p.length(); k=k+2) {
            if(p.charAt(k-1) == '*'){  //如果当前节点k为“*”就可以让前面的字符失效
                dp[0][k] = dp[0][k-2];
            }
        }

        for (int i = 0; i < s.length() ; i++) {
            for (int j = 0; j < p.length(); j++) {
                //第一种情况：两个字符串将要添加的字符是相等的，直接添加
                if(s.charAt(i) == p.charAt(j) || p.charAt(j)=='.'){
                    dp[i+1][j+1] = dp[i][j];
                }

                //第二种情况,有通配符*的情况
                if(p.charAt(j) == '*'){
                    //p字符串的前一个字符与s串的当前字符不相等，也就是说p不能通过*代表前一个字符的方式和s
                    if(p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) !='.'){
                        //相当于放弃p的通配符* 和其前面的字符
                        dp[i+1][j+1] = dp[i+1][j-1];
                    }else{
                        //p字符串的前一个字符和s字符串的当前字符可以匹配上
                        dp[i+1][j+1] = dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "a*b*c*d*";

        boolean match = new Ismatch().isMatch(s, p);

    }
}
