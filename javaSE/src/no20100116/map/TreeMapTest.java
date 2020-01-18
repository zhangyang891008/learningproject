package no20100116.map;

import java.util.Iterator;
import java.util.TreeMap;

/**
 *TreeMap：
 *
 */
public class TreeMapTest {
    
    public static void main(String[] args) {
        TreeMap<MyKey,Object> myMap = new TreeMap<>();
        for (int i = 0; i < 10; i++) {
            myMap.put(new MyKey(i),new Object());
        }
        //iterator
        Iterator<MyKey> iterator = myMap.keySet().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}

class MyKey implements Comparable<MyKey>{
    private Integer id;

    public MyKey(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof MyKey){
            MyKey other = (MyKey) obj;
            return this.id == other.id;
        }
        return false;
    }

    @Override
    public int compareTo(MyKey o) {
        return this.id > o.id ? 1:-1;
    }

    @Override
    public String toString() {
        return "MyKey{" +
                "id=" + id +
                '}';
    }
}