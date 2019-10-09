package newcode.les03;

import java.util.List;
import java.util.Stack;

/**
 * 实现一个特殊的数组：实现正常的出栈入栈操纵，并且出栈可以返回当前栈中的最小值，且时间复杂度为O（1）
 *
 *
 */

public class L03_StackMin {

    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int val){
        data.push(val);
        if(min.empty()){
            min.push(val);
        }else{
            min.push(min.peek()<val? min.peek():val );
        }

    }

    public int[] pop(){
        int[] ret = new int[2];
        ret[0] = data.pop();
        ret[1] = min.pop();
        return ret;
    }
    public static void main(String[] args) {
        L03_StackMin t = new L03_StackMin();

        int[] datas = {9,4,5,3,7,6};

        for (int data : datas) {
            t.push(data);
        }

        for (int i = 0; i < 6; i++) {
            int[] pop = t.pop();
            System.out.println("pop:" + pop[0] + ", min:"+pop[1]);

        }

    }
}
