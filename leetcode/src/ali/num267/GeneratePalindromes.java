package ali.num267;

import java.lang.reflect.Array;
import java.util.*;

/*
267. 回文排列 II

给定一个字符串 s ，返回其通过重新排列组合后所有可能的回文字符串，并去除重复的组合。

如不能形成任何回文排列时，则返回一个空列表。

示例 1：

输入: "aabb"
输出: ["abba", "baab"]
示例 2：

输入: "abc"
输出: []
 */
public class GeneratePalindromes {
    /**
     * 回溯法+减枝叶 类似题目：46，47题
     * @param s
     * @return
     */

    public List<String> generatePalindromes(String s) {

        ArrayList<String> res = new ArrayList<>();
        if(s == null || s.length() == 0){
            res.add("");
            return res;
        }
        if(s.length() == 1){
            res.add(s);
            return res;
        }

        //1.统计每个字符出现的次数，并存入counts
        HashMap<Character,Integer> counts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            counts.put(s.charAt(i),counts.getOrDefault(s.charAt(i),0)+1);
        }

        List<Character> chars = new ArrayList<>();
        //2.把字符出出现次数除2放入chars，如果有两个字符出现的次数为奇数次，不能组成回文，直接返回res.
        boolean hasOdd = false;
        char odd = 'a';
        for (Character key : counts.keySet()) {
            int times = counts.get(key);
            if(times%2 == 1){
                if(hasOdd){
                    return res;
                }else{
                    hasOdd = true;
                    odd = key;
                }
            }else{
                //key出现次数为偶数，没有特殊操作
            }

            int putTimes = times/2;
            while(putTimes>0){
                putTimes--;
                chars.add(key);
            }
        }

        Collections.sort(chars);

        //回溯法
        for (int i = 0; i < chars.size(); i++) {
            if(i>0 && chars.get(i) == chars.get(i-1)){
                continue; //相同字符减枝
            }
            int[] visit= new int[chars.size()];
            visit[i] = 1;
            if(hasOdd){
                //如果存在奇数次数的字符，把这个字符拼接在中间。
                backtrace(res, chars, visit, ""+chars.get(i)+odd+chars.get(i),1);
            }else{
                backtrace(res, chars, visit, ""+chars.get(i)+chars.get(i),1);
            }

        }

        return res;
    }

    private void backtrace(ArrayList<String> res, List<Character> chars, int[] visit, String s, int count) {

        if(count == chars.size()){
            res.add(s);
            return;
        }

        HashSet<Character> hist = new HashSet<>();

        for (int i = 0; i < chars.size(); i++) {
            if(visit[i]==1)  //访问过的节点不再访问
                continue;
            if(hist.contains(chars.get(i))) //减枝
                continue;

            hist.add(chars.get(i));
            visit[i] = 1;

            backtrace(res, chars,visit, chars.get(i)+s+chars.get(i) ,count+1);
            visit[i] = 0;
        }

    }

    public static void main(String[] args) {
        String  s ="a";
        List<String> strings = new GeneratePalindromes().generatePalindromes(s);
    }

}
