package newcode.les03;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 两个队列实现栈功能。
 *
 */
public class L04_StackbyQueue {
    ArrayQueue<Integer> dataQueue = new ArrayQueue<>(10);
    ArrayQueue<Integer> helpQueue = new ArrayQueue<>(10);

    public void push(int val){
        dataQueue.add(val);
    }
    /*将前n-1个元素存入辅助队列，最后一个元素出队列返回。*/
    public int pop(){
        int remove = 0;
        while(!dataQueue.isEmpty()){
            remove = dataQueue.remove(0);
            if(dataQueue.isEmpty()){
                break;
            }else {
                helpQueue.add(remove);
            }
        }

        /*交换两个指针，让dataQueue一直指向数据，helpQueue一直作为辅助。*/
        ArrayQueue<Integer> tempQueue = dataQueue;
        dataQueue = helpQueue;
        helpQueue = tempQueue;
        return remove;
    }

    public static void main(String[] args) {
        L04_StackbyQueue t = new L04_StackbyQueue();
        t.push(1);
        t.push(2);
        t.push(3);
        System.out.println(t.pop());
        System.out.println(t.pop());
        System.out.println(t.pop());
    }
}
