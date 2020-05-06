package ali.num04;

/*
4. 寻找两个有序数组的中位数

给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5
 */






/* 比较容易的理解方法：

 * 1.首先，让我们在任一位置 i 将 A(长度为m) 划分成两个部分：
 *            leftA            |                rightA
 *   A[0],A[1],...      A[i-1] |  A[i],A[i+1],...A[m - 1]
 *
 * 由于A有m个元素，所以有m + 1中划分方式(i = 0 ~ m)
 *
 * 我们知道len(leftA) = i, len(rightA) = m - i;
 * 注意：当i = 0时，leftA是空集，而当i = m时，rightA为空集。
 *
 * 2.采用同样的方式，将B也划分为两部分：
 *            leftB            |                rightB
 *   B[0],B[1],...      B[j-1] |   B[j],B[j+1],...B[n - 1]
 *  我们知道len(leftA) = j, len(rightA) = n - j;
 *
 *  将leftA和leftB放入一个集合，将rightA和rightB放入一个集合。再把这两个集合分别命名为leftPart和rightPart。
 *
 *            leftPart         |                rightPart
 *   A[0],A[1],...      A[i-1] |  A[i],A[i+1],...A[m - 1]
 *   B[0],B[1],...      B[j-1] |  B[j],B[j+1],...B[n - 1]
 *
 *   如果我们可以确认：
 *   1.len(leftPart) = len(rightPart); =====> 该条件在m+n为奇数时，该推理不成立
 *   2.max(leftPart) <= min(rightPart);
 *
 *   median = (max(leftPart) + min(rightPart)) / 2;  目标结果
 *
 *   要确保这两个条件满足：
 *   1.i + j = m - i + n - j(或m - i + n - j + 1)  如果n >= m。只需要使i = 0 ~ m，j = (m+n+1)/2-i =====> 该条件在m+n为奇数/偶数时，该推理都成立
 *   2.B[j] >= A[i-1] 并且 A[i] >= B[j-1]
 *
 *   注意:
 *   1.临界条件：i=0,j=0,i=m,j=n。需要考虑
 *   2.为什么n >= m ? 由于0 <= i <= m且j = (m+n+1)/2-i,必须确保j不能为负数。
 *
 *   按照以下步骤进行二叉树搜索
 *   1.设imin = 0,imax = m，然后开始在[imin,imax]中进行搜索
 *   2.令i = (imin+imax) / 2, j = (m+n+1)/2-i
 *   3.现在我们有len(leftPart) = len(rightPart)。而我们只会遇到三种情况：
 *
 *      ①.B[j] >= A[i-1] 并且 A[i] >= B[j-1]  满足条件
 *      ②.B[j-1] > A[i]。此时应该把i增大。 即imin = i + 1;
 *      ③.A[i-1] > B[j]。此时应该把i减小。 即imax = i - 1;
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenA = nums1.length;
        int lenB = nums2.length;

        //考虑效率，手动调整数组，使得数组A始终是长度较短的数组
        if(lenA > lenB){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;

            //交换数组长度
            lenA = nums1.length;
            lenB = nums2.length;
        }

        int mid  = (lenA + lenB +1)/2; //取中间值加一是为了保证两个数组长度和为奇数的时候，中位数出现在左侧

        int iMin = 0;
        int iMax = lenA;

        while(iMin<=iMax){
            int i = (iMin + iMax) /2;

            /* j的赋值依据
            调整的目标：1.左右两侧元素数量相等或者差一；2.左侧最大值小于等于右侧最小值；
             */
            int j = mid - i;

            if(i<iMax && nums1[i] < nums2[j-1]){
                iMin++;              //i is too small
            }else if(i>iMin && nums1[i-1] > nums2[j]){
                iMax--;              //i is too big
            }else{
                //bingo
                int leftMax ;

                if(j == 0){
                    leftMax = nums1[i-1];
                }else if(i == 0){
                    leftMax = nums2[j-1];
                }else{
                    leftMax = Math.max(nums1[i-1], nums2[j-1]);
                }
                //如果数组的和是奇数，左侧最大值就是中位数
                if( (lenA + lenB) %2 == 1){
                    return leftMax;
                }

                int rightMin ;

                if(j ==  lenB){
                    rightMin = nums1[i];
                }else if(i == lenA){
                    rightMin = nums2[j];
                }else{
                    rightMin = Math.min(nums1[i],nums2[j]);
                }

                return (leftMax + rightMin)/2.0;

            }
        }
        return 0.0;

    }

    public static void main(String[] args) {

        int[] a = {1,3};
        int[] b = {2};

        double medianSortedArrays = new FindMedianSortedArrays().findMedianSortedArrays(a, b);
        System.out.println(medianSortedArrays);

    }
}
