package ali.num75;

/*

75. 颜色分类

给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。

注意:
不能使用代码库中的排序函数来解决这道题。

示例:

输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]
进阶：

一个直观的解决方案是使用计数排序的两趟扫描算法。
首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class SortColors {

    /**
     * 荷兰国旗问题
     * @param nums
     */
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <2)
            return;
        int flag = -1;  //flag表示为0的最后一个节点，边界
        int left = 0;
        int right= nums.length - 1;
        while(left<=right){
            if(nums[left]==0){
                swap(nums, left++, ++flag);  //前面的元素都是验证过的，所以left++
            }else if(nums[left] == 1){
                left++;
            }else{
                swap(nums, left, right--);
            }
        }
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr= {2,0,2,1,1,0};
        new SortColors().sortColors(arr);
        System.out.println("1");
    }
}
