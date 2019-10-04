package newcode.les01.sort;

import newcode.les01.sort.BubboSort;

public class InsertionSort {

    public static void insertionSort(int[] arr){
        if(arr == null || arr.length <2){
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for(int j = i; j>0 && arr[j] < arr[j-1]; j--){
                swap(arr, j, j-1);
            }
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
