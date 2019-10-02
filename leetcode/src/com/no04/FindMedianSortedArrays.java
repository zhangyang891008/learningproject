package com.no04;

public class FindMedianSortedArrays {


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1 == null || nums1.length == 0){
            return calculate(nums2);

        }

        if(nums2 == null || nums2.length == 0){
            return calculate(nums1);
        }

        int a_start = 0;
        int a_end = nums1.length -1;

        int b_start=0;
        int b_end = nums2.length -1;

        int a_mid =  a_start + (a_end - a_start) /2;
        int b_mid = b_start + (b_end - b_start) /2;

        while(a_end - a_start>1 && b_end -b_start >1){

            if(a_mid > b_mid) {
                a_end = a_mid;
            } else{
                b_start = b_mid;
            }
        }


        return 0;
    }

    private static double calculate(int[] nums2){
        int mid_pos = nums2.length/2;
        return nums2.length%2 == 1 ? nums2[mid_pos] : (nums2[mid_pos-1] + nums2[mid_pos])/2.0;
    }

    public static void main(String[] args) {
       int[] num2 = {1,3,5,6,7};

        double medianSortedArrays = findMedianSortedArrays(null, num2);
        System.out.println(medianSortedArrays);
    }
}
