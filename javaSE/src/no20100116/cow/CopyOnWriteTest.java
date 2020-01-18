package no20100116.cow;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * COW家族：Copy-On-Write家族，因为其机制，只适合读多写极少的场景。
 * 测试对比：对比其他容器和COW容器在写入时的性能差异
 *
 */
public class CopyOnWriteTest {

    public static ArrayList<String> arrayList = new ArrayList<>();
    public static CopyOnWriteArrayList<String> cowList = new CopyOnWriteArrayList<>();

    public static void  cowWrite(){
        long start = System.currentTimeMillis();

        // do add operation
        for (int i = 0; i < 100000; i++) {
            cowList.add("cow- " + i);
        }

        long end = System.currentTimeMillis();
        System.out.println("cow cost:" +  (end - start));
    }

    public static void arrayList(){
        long start= System.currentTimeMillis();

        // do  add operation
        for (int i = 0; i < 100000; i++) {
            arrayList.add("arr-"+i);
        }

        long end = System.currentTimeMillis();
        System.out.println("array cost:" + (end - start));
    }

    public static void main(String[] args) {
        cowWrite();
        arrayList();
    }
}
