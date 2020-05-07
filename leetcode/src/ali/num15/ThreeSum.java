package ali.num15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
15. 三数之和

给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
 */
public class ThreeSum {

    /*
    解题思路：首先排序称为一个递增的数组，然后逐个循环数组中的每一个元素，作为结果集的第一个元素（后继元素如果跟前驱相等，要减枝），后续的元素用两个指针记录为left，right；通过比较和是否大于0进行滑动。
    如果三个数的和是0，就添加到结果集合中，如果和为0，left++ right--，继续寻找其他答案（注意这个过程要减枝！）
     */

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        if(nums == null || nums.length<3){
            return ans;
        }
        //首先排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-2; i++) {
            //减枝，如果最小的元素都已经大于零了，不可能三个数的和为零
            if(nums[i]>0){
                break;
            }

            if(i>0 && nums[i-1] == nums[i])  //减枝
                continue;

            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[left] + nums[right] + nums[i];
                if( sum > 0){
                    right--;
                } else if( sum < 0 ){
                    left++;
                }else{
                    ans.add(Arrays.asList(nums[i] , nums[left], nums[right]));
                    while(right>0 && nums[right] == nums[right-1]){ //减枝
                        right--;
                    }
                    while(left<nums.length-1 && nums[left] == nums[left+1]){
                        left++;
                    }
                    left++;
                    right--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0};
        List<List<Integer>> lists = new ThreeSum().threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println("-----");
            list.forEach(System.out::println);
        }
    }
}
