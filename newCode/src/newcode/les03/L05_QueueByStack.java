package newcode.les03;

import java.util.Stack;

/**
 * 用两个栈实现队列：一个栈用于接受数据，一个用于缓存。
 * 要求enqueue，直接压栈data即可
 * 一旦要求dequeue拿出元素，先检查cache栈中是否有元素，如果有出栈即可，如果没有，要一次性将data栈中的元素弹出并入cache，然后从cache出栈返回数据
 */
public class L05_QueueByStack {

    Stack<String> data = new Stack<>();
    Stack<String> cache = new Stack<>();

    public void enQueue(String val){
        data.push(val);
    }

    public String deQueue(){
        if(!cache.isEmpty()){
            return cache.pop();
        }

        //将data中的数据一次性push到cache中

        while(!data.isEmpty()){
            cache.push(data.pop());
        }
        return cache.pop();
    }

    public static void main(String[] args) {
            L05_QueueByStack queue = new L05_QueueByStack();
            queue.enQueue("hello");
            queue.enQueue("world");
        System.out.println(queue.deQueue());
        queue.enQueue("nihao");
        queue.enQueue("zaijian");
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());

    }
}
