package ali.num215;

import java.util.Random;

/*
215. 数组中的第K个最大元素
难度中等
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
示例 1:
输入: [3,2,1,5,6,4] 和 k = 2
输出: 5

示例 2:
输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
说明:
你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class FindKthLargest {

    /*
    解答：找到第K大元素，就是找到数组中 size-k位置上的元素。随机选择节点，把小于该节点的交换到左侧，大于该节点的交换到右侧，如果随机节点的位置正好为size-k，这返回该位置对应的值。
        否则，根据选定节点的位置与size-k比较，更新左右边界。
        if(random == size - k)
            return arr[size-k];
        else if(random <size-k)
            right = random-1;
        else if(random > size - k)
            left = random + 1；
     */

    int[] nums;

    public int findKthLargest(int[] nums, int k) {

        if (nums == null || nums.length == 0) {
            return -1;
        }
        this.nums = nums;

        int ret =  quicksort(0, nums.length-1, nums.length - k);
        return ret;
    }

    private int quicksort(int left, int right,int dest) {
        if(left == right)
            return nums[left];
        Random random = new Random();

        int mid = partition(left, right ,left+random.nextInt(right-left) );

        if(dest == mid){
            return nums[dest];
        }else if(dest < mid){
            return quicksort(left, mid - 1, dest);
        }
        return quicksort(mid+1, right, dest);

    }


    //根据destpos进行
    public int partition(int left, int right, int destpos){
        int target = nums[destpos];
        swap(right, destpos);

        int retpos = left;
        for (int i = left; i <=right ; i++) {
            if(nums[i] < target){
                swap(retpos,i);
                retpos++;
            }
        }

        swap(retpos, right);
        return retpos;
    }

    public void swap(int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2};
        int kthLargest = new FindKthLargest().findKthLargest(arr, 3);

        System.out.println(kthLargest);

    }
}
