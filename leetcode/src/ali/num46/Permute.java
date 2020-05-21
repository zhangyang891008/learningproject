package ali.num46;

import java.util.ArrayList;
import java.util.List;

/*
46. 全排列

给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class Permute {
    static List<List<Integer>> res;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            res.add(new ArrayList<>());
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            int[] visit = new int[nums.length];
            visit[i] = 1;
            ArrayList<Integer> list = new ArrayList();
            list.add(nums[i]);
            backtrack(res,nums, visit, list,1);
        }

        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, int[] visit, ArrayList<Integer> list, int count) {
        if(count == visit.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < visit.length; i++) {
            if(visit[i] ==1) continue;
            //记录访问标记
            visit[i] = 1;
            list.add(nums[i]);
            backtrack(res, nums,visit,list,count+1);
            list.remove(list.size()-1);
            visit[i] = 0;
        }
        
    }


    public static void main(String[] args) {

    }
}
