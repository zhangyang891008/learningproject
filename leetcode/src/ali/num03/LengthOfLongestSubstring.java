package ali.num03;

import java.util.HashSet;
import java.util.Set;

/*
3. 无重复字符的最长子串

给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

示例 1:

输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class LengthOfLongestSubstring {

    /*
        解题方法：滑动窗口
     */
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }

        Set<Character> charSet = new HashSet<>();

        int len = s.length();
        int curPos = 0;  //记录当前位置
        int ans = 0;     //记录当前最长的不重复字符的长度
        int start = -1;  //记录窗口位置

        while(start+1<s.length()){
            //滑动窗口的移动
            if(start>-1){
                charSet.remove(s.charAt(start));
            }
            start++;

            while(curPos<s.length() && !charSet.contains(s.charAt(curPos))){
                charSet.add(s.charAt(curPos++));
            }

            ans = Math.max(ans, charSet.size());
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "abeee";
        int i = new LengthOfLongestSubstring().lengthOfLongestSubstring(str);
        System.out.println(i);

    }
}
