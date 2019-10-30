package com.no1089;

/*
给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。

注意：请不要在超过该数组长度的位置写入元素。

要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。

示例 1：

输入：[1,0,2,3,0,4,5,0]
输出：null
解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
示例 2：

输入：[1,2,3]
输出：null
解释：调用函数后，输入的数组将被修改为：[1,2,3]
 

提示：

1 <= arr.length <= 10000
0 <= arr[i] <= 9

 */
public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        if(arr==null || arr.length<2)
            return;
        int endPos = -1;
        int counts = 0;
        boolean zeroFlag = false;
        while(counts != arr.length){
            if(!zeroFlag)
                endPos++;

            if(arr[endPos] == 0) {
                if(zeroFlag){
                    zeroFlag = false;
                }else{
                    zeroFlag = true;
                }
            }
            counts++;
        }

        //如果zeroFlag为真，表示当前endPos停在零上。

        for (int i = arr.length - 1; i >= 0 ; i--) {
            if(arr[endPos] == 0){
                if(zeroFlag){
                    arr[i] = arr[endPos--];
                    zeroFlag = false;
                }else{
                    zeroFlag =true;
                    arr[i] = arr[endPos];
                }
            }else{
                arr[i] = arr[endPos--];
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {1,5,2,0,6,8,0,6,0};
        //int[] arr = {8,4,5,0,0,0,0,7};
        //int[] arr = {0,1,7,6,0,2,0,7}; //[0,0,1,7,6,0,0,2]
        new DuplicateZeros().duplicateZeros(arr);
        System.out.println("finish");
    }
}
