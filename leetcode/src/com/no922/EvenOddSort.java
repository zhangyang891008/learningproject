package com.no922;

/*

922. 按奇偶排序数组 II
给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。

对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。

你可以返回任何满足上述条件的数组作为答案。

示例：

输入：[4,2,5,7]
输出：[4,5,2,7]
解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。

提示：

2 <= A.length <= 20000
A.length % 2 == 0
0 <= A[i] <= 1000


 */
public class EvenOddSort {

    public int[] sortArrayByParityII(int[] A) {
        if(A == null || A.length<2)
            return A;

        int evenEnd = (A.length - 1)%2 == 0? (A.length - 1):(A.length -2);
        int oddEnd = (A.length -1)%2 == 1? (A.length - 1) : (A.length - 2);

        int odd = 1;
        int even = 0;

        boolean oddFlag = false;
        boolean evenFlag = false;

        while(odd <= oddEnd && even <= evenEnd){
            if(A[odd]%2 == 1){
                odd += 2;
            }else{
                oddFlag = true;
            }

            if(A[even] % 2 == 0){
                even += 2;
            }else{
                evenFlag = true;
            }

            if(oddFlag && evenFlag){
                int temp = A[odd];
                A[odd] = A[even];
                A[even] = temp;
                oddFlag = false;
                evenFlag = false;
            }
        }
        return A;

    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,2,4,6};
        int[] ints = new EvenOddSort().sortArrayByParityII(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
