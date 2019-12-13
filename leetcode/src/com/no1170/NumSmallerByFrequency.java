package com.no1170;

/*
1170. 比较字符串最小字母出现频次
我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s  中（按字典序比较）最小字母的出现频次。

例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。

现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。

示例 1：

输入：queries = ["cbd"], words = ["zaaaz"]
输出：[1]
解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
示例 2：

输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
输出：[1,2]
解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
 

提示：

1 <= queries.length <= 2000
1 <= words.length <= 2000
1 <= queries[i].length, words[i].length <= 10
queries[i][j], words[i][j] 都是小写英文字母

 */
public class NumSmallerByFrequency {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        if(queries == null || words == null)
            return null;
        //List<Integer> ret = new ArrayList<>();
        int ret[] = new int[queries.length];
        int[] queriresCount = new int[queries.length];
        int[] wordsCount = new int[words.length];
        //count
        compute(queriresCount,queries);
        compute(wordsCount,words);
        //sort
        sort(wordsCount);

        for (int i = 0; i < queriresCount.length; i++) {
            int count = 0;
            for (int j = 0; j < wordsCount.length; j++) {
                if(queriresCount[i] < wordsCount[j]){
                    count = wordsCount.length -j;
                    break;
                }
            }
           //ret.add(count);
            ret[i] = count;
        }
        return ret;
    }

    public static void compute (int[] countArr, String[] stringArr) {
        for (int i = 0; i < stringArr.length; i++) {
            String curQueryStr = stringArr[i];
            //System.out.println(curQueryStr);

            int count = 0;
            if(curQueryStr.length()>0){
                char curChar = curQueryStr.charAt(0);
                count = 1;
                for (int j = 1; j < curQueryStr.length(); j++) {
                    if(curChar <= curQueryStr.charAt(j)){
                        if(curChar == curQueryStr.charAt(j))
                            count++;
                    }else{
                        curChar = curQueryStr.charAt(j);
                        count = 1;
                    }
                }
            }
            countArr[i] = count;
        }
    }

    private static void sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i-1; j >= 0 ; j--) {
                if(arr[j+1]>=arr[j])
                    break;
                int temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        String[] test1 = {"bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"};
        String[] test2 = {"aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"};
        String[] queries = {"bbb","cc","aaaaa"};
        String[] words = {"a","aa","aaa","aaaa"};
        int[] ints = new NumSmallerByFrequency().numSmallerByFrequency(test1, test2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
