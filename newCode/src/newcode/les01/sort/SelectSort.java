package newcode.les01.sort;

import newcode.les01.sort.BubboSort;

public class SelectSort {

    public static void selectSort(int[] arr){

        if(arr == null || arr.length < 2){
            return;
        }

        for (int i = 0; i < arr.length-1; i++) {
            int minPos = i;
            for (int j = i+1; j < arr.length; j++) {
                minPos = arr[j] < arr[minPos]? j : minPos;
            }
            swap(arr, minPos, i);
        }

    }

    private static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr  = {4,2,45,6};
        BubboSort.sort(arr);
        System.out.println("finish");
    }
}
