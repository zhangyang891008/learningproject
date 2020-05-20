package ali.num88;

/*
88. 合并两个有序数组


说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
 */
public class Merge {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = m+n-1;
        int index1 = m-1;
        int index2 = n-1;
        while(pos>=0 && index1 >= 0 && index2>=0){
            if(nums1[index1] > nums2[index2]){
                nums1[pos--] = nums1[index1--] ;
            }else {
                nums1[pos--] = nums2[index2--];
            }
        }
        while(index2>=0){
            nums1[pos--] = nums2[index2--];
        }
        return;
    }

    /*
    [4,5,6,0,0,0]
3
[1,2,3]
3
     */
    public static void main(String[] args) {
        int[] nums1 = {4,5,6,0,0,0};
        int m = 3;
        int n= 3;
        int[] nums2 = {1,2,3};
        new Merge().merge(nums1,m,nums2,n);
    }
}
