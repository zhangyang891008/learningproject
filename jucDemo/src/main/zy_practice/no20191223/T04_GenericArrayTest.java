package no20191223;

import no20191222.Pair;

import java.util.ArrayList;
import java.util.List;

/*
4.不能创建参数化类型的数组，但是可以声明。
    一般情况下，不能创建泛型数组，可以通过ArrayList替代

 */
public class T04_GenericArrayTest {

    public static void main(String[] args) {
        //1.error
        //Pair<String>[] table = new Pair<String>[10];

        //2.ArrayList
        GenericList<String> list = new GenericList<>();
        list.add("hello");
        list.add("world");
        System.out.println(list.get(0));
        System.out.println(list.get(1));

    }
}

// use ArrayList instead of array
class GenericList<T>{
    private List<T> array = new ArrayList<T>();

    public void add(T item){
        array.add(item);
    }

    public T get(int index){
        return array.get(index);
    }
}