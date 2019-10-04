package newcode.les01.recursion;

import java.util.ArrayList;
import java.util.List;

public class reversePair {

    static List<Pair> reversePairs = new ArrayList<>();

    public static List<Pair> reversePair(int[] arr){
        sort(arr, 0, arr.length-1);
        return reversePairs;
    }

    private static void sort(int[] arr, int l, int r){

        if(l==r){
            return;
        }

        int mid = l + (r-l)/2;
        sort(arr, l, mid);
        sort(arr, mid+1, r);
        merge(arr, l, mid, r);

    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int left = l;
        int right = mid+1;

        int[] help = new int[r - l +1];
        int count = 0;

        while(left <= mid && right <=r){
            //添加逆序对
            if(arr[left] > arr[right]){
                for(int rPos = right; rPos<=r; rPos++){
                    reversePairs.add(new Pair(arr[left], arr[rPos]));
                }
            }
            help[count++] = arr[left]<=arr[right] ? arr[left++] : arr[right++];
        }

        while(left <= mid){
            help[count++] = arr[left++];
        }

        while(right <= r){
            help[count++] = arr[right++];
        }

        count = 0;
        //辅助数组写回原数组
        /*
        for (int i = l; i <= r; i++) {
            arr[i++] = help[count++];
        }

         */

        for (int i = 0; i < help.length; i++) {
            arr[l+i] = help[i];
        }
    }


    public static void main(String[] args) {
        int[] arr = {12,33,22,355,332};
        List<Pair> pairs = reversePair(arr);
        System.out.println(arr);
    }
}

class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}