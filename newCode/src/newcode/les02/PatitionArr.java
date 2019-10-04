package newcode.les02;


import java.util.Arrays;

public class PatitionArr {

    public static void partition(int arr[] , int num, int start ,int end){
        if(arr == null || arr.length<2){
            return;
        }
        int leftpos = start;
        int rightpos = end;
            while(leftpos < rightpos ){
                while( arr[leftpos] <= num && leftpos < rightpos){
                    leftpos++;
                }
                while( arr[rightpos] > num && leftpos < rightpos){
                    rightpos--;
                }
                swap(arr, leftpos++, rightpos--);
            }


    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {34,78,19,78,48,25,1,2,33,25,88};
        partition(arr, 25, 0, arr.length -1);
        System.out.println(Arrays.toString(arr));

    }
}
