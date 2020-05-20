package ali.num28;
/*
28. 实现 strStr()

实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0)
            return 0;
        int len = needle.length();
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(0)){
                //只有相同的字符才开始比较
                if(haystack.substring(i,i+len).equals(needle)){
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String a = "a";
        String b = "a";
        int i = new StrStr().strStr(a, b);
        System.out.println(i);
    }
}
