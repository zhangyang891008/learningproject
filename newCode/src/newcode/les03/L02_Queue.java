package newcode.les03;

public class L02_Queue {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        System.out.println(queue.size());
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        System.out.println(queue.size());
        queue.deQueue();
        //queue.enQueue(4);
    }
}
class MyQueue{
    int[] arr = new int[3];
    int head = 0;
    int tail = 0;
    int size = 0;

    public int size(){
        return size;
    }

    public void enQueue(int val){
        if(size >= arr.length)
            throw new RuntimeException("full");
        arr[tail] = val;
        tail = tail>=(arr.length-1) ? 0 : tail+1;
        size++;
    }

    public int deQueue(){
        if(size == 0){
            throw new RuntimeException("empty");
        }
        int remove = arr[head];
        head = (head>=arr.length-1) ? 0: head+1;
        size--;
        return remove;
    }
}