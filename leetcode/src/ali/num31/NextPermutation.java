package ali.num31;

/*
31. 下一个排列

实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <2){
            return;
        }
        int left = 0;
        for (int i = nums.length-1; i >0 ; i--) {
            if(nums[i] > nums[i-1]){
                if(i==nums.length-1){
                    swap(nums,i,i-1);
                    return;
                }
                left = i;  //把i位置到nums.length-1位置的元素升序排列
                int temp  = nums.length -1;
                while(nums[temp]<= nums[i-1]){  //找到从右侧开始第一个大于i-1位置的元素，然后交换
                    temp--;
                }
                swap(nums, temp, i-1);
                break;
            }
        }

        int right= nums.length -1;
        while(left<right){
            swap(nums,left++,right--);
        }
        return;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

    }
}
