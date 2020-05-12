package ali.num153;

/*
153. 寻找旋转排序数组中的最小值

假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

请找出其中最小的元素。

你可以假设数组中不存在重复元素。

示例 1:

输入: [3,4,5,1,2]
输出: 1
示例 2:

输入: [4,5,6,7,0,1,2]
输出: 0
 */
public class FindMin {

    /*
    解答：采用二分查找的方法，当右侧左大右小时，说明最小值在期间，left = mid+1,
    否则right = mid，不加1是因为mid可能是最小值，加1会错过
    此题与153题类似
     */

    public int findMin(int[] nums) {
        if(nums ==null || nums.length == 0){
            return -1;
        }

        int left = 0;
        int right = nums.length-1;

        int mid ;

        while(left < right){
            mid = (left+right) /2;
            if(nums[mid] > nums[right]){
                left = mid +1 ;
            }else {
                right = mid;
            }
        }

        return nums[left];

    }

    public static void main(String[] args) {

    }
}
