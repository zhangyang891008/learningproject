package no20200115.dequeue;

import java.util.LinkedList;

/**
 * java编程思想 chapter17
 *
 */
public class DequeTest {

    static void fillQueue(MyDeque<Integer> queue){
        for (int i = 11; i < 20; i++) {
            queue.addFirst(i);
        }

        for (int i = 20; i < 30; i++) {
            queue.addLast(i);
        }
    }
    public static void main(String[] args) {
        MyDeque<Integer> deque = new MyDeque<>();
        //-------removeFirst
        fillQueue(deque);
        while(deque.size()!=0){
            System.out.println(deque.removeFirst());
        }


        System.out.println("*********");
        //-------removeLast
        fillQueue(deque);
        while(deque.size()!=0){
            System.out.println(deque.removeLast());
        }
    }
}


class MyDeque<T>{
    private LinkedList<T> deque = new LinkedList<T>();

    public void addFirst(T t){
        deque.addFirst(t);
    }

    public void addLast(T t){
        deque.addLast(t);
    }

    public T getFirst(){
        return deque.getFirst();
    }

    public T getLast(){
        return deque.getLast();
    };

    public T removeFirst(){
        return deque.removeFirst();
    }

    public T removeLast(){
        return deque.removeFirst();
    }

    public int size(){
        return deque.size();
    }

    public String toString(){
        return deque.toString();
    }
}