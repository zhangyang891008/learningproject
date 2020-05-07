package ali.num01;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.util.HashMap;

/*
1. 两数之和

给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。


示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
 */
public class TwoSum {

    /*
    解题思路：通过循环，把每个值和数组中对应的位置在map中进行缓存，
            通过查找target-nums[i]的值在map中是否存在

     */

    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length<2){
            return null;
        }
        HashMap<Integer,Integer> val_pos = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(val_pos.containsKey(target - nums[i])){
                return new int[]{val_pos.get(target - nums[i]), i};
            }
            val_pos.put(nums[i],i);
        }
        return null;
    }

    public static void main(String[] args) {
    int[] nums = {2, 7, 11, 15};
    int[] ints = new TwoSum().twoSum(nums,13);
    System.out.println("---"+ ints[0]+","+ints[1]);
}
}
