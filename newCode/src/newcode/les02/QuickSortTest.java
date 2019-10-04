package newcode.les02;

import java.util.Arrays;

public class QuickSortTest {

    public static void quickSort(int[] arr){
        if(arr ==null || arr.length<2)
            return;

        partition(arr, 0, arr.length - 1);

    }


    private static void partition(int[] arr, int l, int r){
        if(l < r){
            int[] ret = part(arr,l,r);
            partition(arr,l,ret[0]-1);
            partition(arr,ret[1]+1,r);
        }

    }

    private static int[] part(int[] arr, int l, int r){
        int less = l-1;
        int more = r;
        int cur = l;
        while(cur<more){
            if(arr[cur] < arr[r]){
                swap(arr, cur++, ++less);
            }else if(arr[cur] == arr[r]){
                cur++;
            }else{
                //cur>r
                swap(arr, cur,--more);
                //cur原地不动
            }
        }

        //交换哨兵位置r
        swap(arr, more, r);

        return new int[]{less+1, more};
    }
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {0,88,23,99,0,88,23,55};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
