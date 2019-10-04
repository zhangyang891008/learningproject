package newcode.les01.recursion;

/**
 * 递归：求最大值
 */
public class getMax {

    public static int getMax(int[] arr){


        int max = max(arr, 0, arr.length - 1);
        return max;

    }

    private static int max(int[] arr, int l, int r){
        if(l==r){
            return arr[l];
        }

        int mid = l + (r - l)/2;
        int maxLeft = max(arr, l, mid);
        int maxRight = max(arr, mid+1, r);
        return maxLeft >= maxRight? maxLeft : maxRight;
    }


    public static void main(String[] args) {

        int[] arr = {12};
        int max = getMax(arr);
        System.out.println(max);

    }
}
