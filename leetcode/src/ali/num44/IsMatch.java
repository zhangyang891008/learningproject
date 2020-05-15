package ali.num44;
/*
44. 通配符匹配

给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。

'?' 可以匹配任何单个字符。
'*' 可以匹配任意字符串（包括空字符串）。
两个字符串完全匹配才算匹配成功。

说明:

s 可能为空，且只包含从 a-z 的小写字母。
p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
示例 1:

输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。
示例 2:

输入:
s = "aa"
p = "*"
输出: true
解释: '*' 可以匹配任意字符串。
示例 3:

输入:
s = "cb"
p = "?a"
输出: false
解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
示例 4:

输入:
s = "adceb"
p = "*a*b"
输出: true
解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
示例 5:

输入:
s = "acdcb"
p = "a*c?b"
输入: false
 */
public class IsMatch {
    /**
     * 解法：动态规划，如果匹配到* 字符，可以为空，或者匹配多个字符。
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if(s == null || p==null)
            return false;
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] =true;

        //只有所有节点都为* 的情况下能够匹配s空串的情况
        for (int k = 0; k < p.length(); k++) {
            if(p.charAt(k) == '*' && dp[0][k] ){
                dp[0][k+1] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if(p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)){
                    dp[i+1][j+1] = dp[i][j];
                }else if(p.charAt(j) == '*'){
                    dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j];
                }
            }
        }

        return dp[s.length()][p.length()];

    }

    public static void main(String[] args) {
        String s = "aa";
        String p = "a";
        boolean match = new IsMatch().isMatch(s, p);
        System.out.println(match);
    }
}
