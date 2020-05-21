package ali.num47;

import java.util.*;

/*
47. 全排列 II

给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */
public class PermuteUnique {

    /**
     * 回溯法：注意剪纸，当前访问过并且回退的节点不能重复
     */

    static List<List<Integer>> res;
    public List<List<Integer>> permuteUnique(int[] nums) {

        res = new ArrayList<>();
        if(nums == null ||  nums.length == 0){
            res.add(new ArrayList<>());
            return res;
        }

        //1.首先排序
        ArrayList<Integer> sortedList = new ArrayList<>();
        for (int num : nums) {
            sortedList.add(num);
        }
        Collections.sort(sortedList);

        //2.减枝，遍历
        for (int i = 0; i < sortedList.size(); i++) {
            if(i>0 && sortedList.get(i) == sortedList.get(i-1))
                continue;

            int[] visit = new int[sortedList.size()];
            visit[i] = 1;
            ArrayList<Integer> list = new ArrayList<>();
            list.add(sortedList.get(i));
            backtrace(sortedList, visit, list );
        }
        return res;
    }

    private void backtrace(ArrayList<Integer> sortedList, int[] visit, ArrayList<Integer> list) {

        if(list.size() == sortedList.size()){
            res.add(new ArrayList<>(list));
            return ;
        }

        Set<Integer> hist = new HashSet<>();
        for (int i = 0; i < sortedList.size(); i++) {
            if(visit[i] == 1) continue;

            if(hist.contains(sortedList.get(i)))
                continue;
            hist.add(sortedList.get(i));//减枝，相同节点刚被访问过
            visit[i] = 1;
            list.add(sortedList.get(i));
            backtrace(sortedList, visit,list);
            list.remove(list.size()-1);
            visit[i] = 0;
        }

    }


    public static void main(String[] args) {

    }
}
