package ali.num05;

/*
5. 最长回文子串

给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"
 */
public class LongestPalindrome {

    /*
    中心扩展算法：
    事实上，只需使用恒定的空间，我们就可以在 O(n^2) 的时间内解决这个问题。

    我们观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n - 1个这样的中心。

    你可能会问，为什么会是 2n - 1个，而不是 nn 个中心？原因在于所含字母数为偶数的回文的中心可以处于两字母之间（例如 \textrm{“abba”}“abba” 的中心在两个 \textrm{‘b’}‘b’ 之间）。

     */

    public String longestPalindrome(String s) {

        int start = 0;
        int end  = 0;

        if(s == null || s.length() == 0){
            return "";
        }

        for (int i = 0; i < s.length(); i++) {
            int[] center = expend(s,i,i);
            if(center[1] - center[0] > end -start){
                start = center[0];
                end = center[1];
            }
            center = expend(s,i,i+1);
            if(center[1] - center[0] > end -start){
                start = center[0];
                end = center[1];
            }

        }

        return s.substring(start, end+1);
    }

    public int[] expend(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        return new int[]{++left, --right};
    }

    public static void main(String[] args) {

    }

}
