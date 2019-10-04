package newcode.les01.recursion;

/**
 * 求数组的最小和，一个数组中如果当前元素的前面有小于它的元素，累加起来
 */
public class minimalSum {

    public static int getMinimalSum(int[] arr){
        int minimalSum = getMinimalSum(arr, 0, arr.length - 1);
        return minimalSum;
    }

    private static int getMinimalSum(int[] arr, int l, int r) {
        if(l==r){
            return 0;
        }

        int mid = l + (r-l)/2;
        int leftSum = getMinimalSum(arr, l, mid);
        int rightSum = getMinimalSum(arr, mid+1, r);
        int mergeSum = merge(arr, l, mid, r);
        return leftSum + rightSum + mergeSum;

    }

    private static int merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r-l+1];
        int left = l;
        int right = mid+1;
        int count = 0;
        int mergeSum = 0;

        while(left <= mid && right <= r){
            mergeSum += arr[left] < arr[right] ? (arr[left]*(r-right+1)) : 0;
            help[count++] = arr[left] <= arr[right] ? arr[left++] : arr[right++];
        }

        while(left<=mid){
            help[count++] = arr[left++];
        }

        while(right<=r){
            help[count++] = arr[right++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[l+i] = help[i];

        }

        return mergeSum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,7,4,3};  //10
        int minimalSum = getMinimalSum(arr);
        System.out.println(minimalSum);
    }
}
