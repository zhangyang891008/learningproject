package com.no1023;

import java.util.ArrayList;
import java.util.List;

/*
1023. 驼峰式匹配
如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 个字符。）

给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。

示例 1：

输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
输出：[true,false,true,true,false]
示例：
"FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
"FootBall" 可以这样生成："F" + "oot" + "B" + "all".
"FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer".
示例 2：

输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
输出：[true,false,true,false,false]
解释：
"FooBar" 可以这样生成："Fo" + "o" + "Ba" + "r".
"FootBall" 可以这样生成："Fo" + "ot" + "Ba" + "ll".
示例 3：

输出：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
输入：[false,true,false,false,false]
解释：
"FooBarTest" 可以这样生成："Fo" + "o" + "Ba" + "r" + "T" + "est".
 

提示：

1 <= queries.length <= 100
1 <= queries[i].length <= 100
1 <= pattern.length <= 100
所有字符串都仅由大写和小写英文字母组成。

 */
public class CamelMatch {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ret = new ArrayList<>(queries.length);
        for (String query:queries){
            int index = 0;
            boolean finished = false;
            for (int i = 0; i < pattern.length(); i++) {
                char patternChar = pattern.charAt(i);
                //如果是大写字母，逐一向后查找，直到遇到大写字母才比较，遍历到末尾表示不符合
                if(isUpperCase(patternChar)){
                    //遍历查找大写字母
                    while(index<query.length() && isLowerCase(query.charAt(index))){
                        index++;
                    }
                    //未找到的情况，遍历到结尾或者找到不相等
                    if(index == query.length() || query.charAt(index)!=patternChar){
                        ret.add(false);
                        finished = true;
                        break;
                    }
                    index++;
                }else{
                    if(isLowerCase(query.charAt(index)) && query.charAt(index)==patternChar){
                        index++;
                        continue;
                    }
                    boolean flag = false;
                    //判断下一个大写字母前是否存在pattern中的小写字母
                    while((index+1)<query.length() &&  isLowerCase( query.charAt(index+1))){
                        index++;
                        if(query.charAt(index)==patternChar){
                            index++;
                            flag = true;
                            break;
                        }
                    }
                    if(!flag){
                        ret.add(false);
                        finished = true;
                        break;
                    }

                }
            }
            //check if there is a uppercase exist
            if(!finished){
                while(index<query.length()){
                    if(isUpperCase(query.charAt(index))){
                        ret.add(false);
                        break;
                    }
                    index++;
                }
                if(index==query.length())
                    ret.add(true);
            }

        }
        return ret;
    }

    private boolean isUpperCase(char ch){
        if(ch>='A' && ch<='Z')
            return true;
        return false;
    }

    private boolean isLowerCase(char ch){
        if(ch>='a' && ch<='z')
            return true;
        return false;
    }

    public static void main(String[] args) {
       // 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
        //输出：[true,false,true,false,false]
        String[] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern = "FoBa";
        String pattern2 = "FoBaT";


        //List<Boolean> booleans = new CamelMatch().camelMatch(queries, pattern2);
        //booleans.stream().forEach(System.out::println);

        //["CompetitiveProgramming","CounterPick","ControlPanel"]
        //"CooP"
        String[] queries2 = {"CompetitiveProgramming","CounterPick","ControlPanel"};
        String queryPatter = "CooP";
        List<Boolean> booleans2 = new CamelMatch().camelMatch(queries2, queryPatter);
        booleans2.stream().forEach(System.out::println);

    }
}
