package newcode.les01.sort;

public class BubboSort {


    public static void sort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }

        for (int i = arr.length-1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j+1]){
                    swap(arr, j , j+1);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j){
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
