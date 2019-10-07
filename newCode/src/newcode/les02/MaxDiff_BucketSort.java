package newcode.les02;

/**
 * 给定一个数组，如果排序后，求相邻两个数的最大差值，用不能用基于比较的排序方法
 *
 */
public class MaxDiff_BucketSort {

    public static int  BucketSort(int[] arr){

        boolean[] hasElem = new boolean[arr.length+1];
        int[] min = new int[arr.length+1];
        int[] max = new int[arr.length+1];
        for (int i = 0; i < min.length; i++) {
            min[i] = Integer.MAX_VALUE;
        }

        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        //0.找出最大最小值
        for (int i = 0; i < arr.length; i++) {
            maxVal = arr[i]>maxVal ? arr[i]:maxVal;
            minVal = arr[i]<minVal ? arr[i]:minVal;
        }

        //1.把元素装入水桶中
        int gap = (maxVal - minVal)/arr.length;
        for (int i = 0; i < arr.length; i++) {
            int bucket = (arr[i] - minVal)/gap;
            hasElem[bucket] = true;
            min[bucket] = min[bucket]<arr[i]?min[bucket]:arr[i];
            max[bucket] = max[bucket]>arr[i]?max[bucket]:arr[i];
        }

        int result = 0;
        //2.循环一次，算出最大差值
        for (int i = 1, cur = 0; i < hasElem.length; i++) {
            if(hasElem[i]){
                result = (min[i] - max[cur])>result? (min[i] - max[cur]):result;
                cur = i;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int res =  BucketSort(new int[]{1,8,6,9,1});
        System.out.println(res);
    }
}
