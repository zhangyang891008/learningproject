package no20100114.generatorlist;

import java.util.*;


/**
 * Generator解决填充数据问题
 *
 * CollectionData是一个适配器模式，将Generator适配到Collections上
 *
 *
 * @param <T>
 */
class CollectionData<T> extends ArrayList<T>{
    public CollectionData(Generator<T> gen, int quantity){
        for (int i = 0; i < quantity; i++) {
            add(gen.next());
        }
    }

    public static <T> CollectionData<T> list(Generator<T> gen, int quantity){
        return new CollectionData<T>(gen, quantity);
    }
}

class Goverment implements Generator<String> {
    String[] foundation = {"a","b","c","d"};

    private int next;
    @Override
    public String next() {
        return foundation[next++];
    }
}

public class CollectionDataTest{
    public static void main(String[] args) {

        CollectionData<String> list = CollectionData.list(new Goverment(), 4);
        System.out.println(list);
    }
}
