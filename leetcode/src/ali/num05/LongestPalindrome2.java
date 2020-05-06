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
public class LongestPalindrome2 {

    /*
    2动态规划方法：用二维数组保存判断结果，然后进一步判断当前字符串是否回文，因为字符串有序，所以二维数组只有上半部分有意义

     */

    public String longestPalindrome(String s) {

        if(s == null || s.length() == 0){
            return "";
        }


        boolean[][] state = new boolean[s.length()][s.length()];

        // (i,i)一定是回文，因为字符串长度为1
        for (int k = 0; k < s.length(); k++) {
            state[k][k] = true;
        }

        int len = 1;
        int start = 0;

        for (int j = 1; j < s.length(); j++) {

            for (int i = 0; i < j; i++) {
                if(s.charAt(i) == s.charAt(j)){
                    if(j-i<3){
                        state[i][j] = true;   //因为相差小于三，中间最多一个字符，一个字符无论是什么都是符合回文的，减少操作次数
                    }else{
                        state[i][j] = state[i+1][j-1];
                    }
                }else{
                    state[i][j] = false;
                }

                //如果当前字串是回文，比较和更新
                if(state[i][j]){
                    int curLen = j - i +1;
                    if(curLen>len){
                        len = curLen;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start+len);

    }



    public static void main(String[] args) {

    }

}
