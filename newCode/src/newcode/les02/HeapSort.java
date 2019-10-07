package newcode.les02;

public class HeapSort {

    public static void heapSort(int[] arr){
        if(arr == null || arr.length<2){
            return;
        }
        //1.调整为大顶堆
        for (int i = 1; i < arr.length; i++) {
            heapInsert(arr, i);

        }

        //2交换堆顶和堆中的最后一个元素
        for (int i = arr.length -1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
        //调整堆heapify()
    }

    private static void heapInsert(int[] arr, int cur){

            int father = (cur-1)/2;
            while(arr[father] < arr[cur]){
                swap(arr, father, cur);
                cur = father;
                father = (cur - 1)/2;
            }

    }

    private static void heapify(int[] arr, int start, int heapSize){
        int cur = start;
        int left = start*2 + 1;
        while(left<heapSize){
            int largestPos = left;
            int right = left+1;
            if(right<heapSize){
                largestPos = arr[right]> arr[left]?right:largestPos;
            }

            if(arr[largestPos]>arr[cur]){
                swap(arr, cur, largestPos);
                cur = largestPos;
                left = cur*2+1;
            }else{
                break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {7,9,3,4,5,5,9};
        heapSort(arr);
        System.out.println("finish");
    }
}
