package newcode.les02;

import java.util.Arrays;

public class FlagsTest {

    public static void partition(int[] arr, int l, int r, int num){
        int less = l-1;
        int more = r+1;
        int cur = l;
        while(cur < r){
            if(arr[cur] < num){
                swap(arr, ++less, cur++);
            }else if(arr[cur] == num){
                cur++;
            }else{
                //cur > num
                swap(arr, cur, r--);
                //cur 不后移动，因为交换过来的数字是多少没有经过判定
            }
        }

        //返回等于区域的下下标  [less+1 more-1]

    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {44,22,4,22,56,66,32,22,21};
        partition(arr,0,arr.length - 1, 22);
        System.out.println(Arrays.toString(arr));
    }
}
