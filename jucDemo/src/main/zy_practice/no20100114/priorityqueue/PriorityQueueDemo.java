package no20100114.priorityqueue;

import java.util.PriorityQueue;

/**
 * PriorityQueue:元素需要实现Comparable接口或者传入自定义的Comparator
 *
 */
public class PriorityQueueDemo {

    public static void main(String[] args) {
        ToDoList toDoItems = new ToDoList();
        toDoItems.add(1,2,"haha");
        toDoItems.add(2,1,"ddd");
        toDoItems.add(1,3,"huhu");
        toDoItems.add(2,3,"3eeee");
        while(!toDoItems.isEmpty()){
            System.out.println(toDoItems.remove());
        }
    }
}

class ToDoItem implements Comparable<ToDoItem>{
    int first;
    int second;
    String item;

    @Override
    public String toString() {
        return "ToDoItem{" +
                "first=" + first +
                ", second=" + second +
                ", item='" + item + '\'' +
                '}';
    }

    ToDoItem(int first, int second, String item){
        this.first = first;
        this.second = second;
        this.item = item;
    }

    @Override
    public int compareTo(ToDoItem o) {
        if(this.first > o.first){
            return 1;
        }
        if(this.second>o.second){
            return 1;
        }else if(this.second == o.second){
            return 0;
        }
        return -1;
    }
}

class ToDoList extends PriorityQueue<ToDoItem>{
    public void add(int first, int second,String item){
        add(new ToDoItem(first, second, item));
    }
}