package no20100114.generatormap;

import no20100114.generatorlist.Generator;

import java.util.LinkedHashMap;

/**
 * java编程思想 chapter17
 * 通过Generator 和适配器实现 map容器的填充
 *
 * @param <K>
 * @param <V>
 */
class Pair<K,V>{
    K key;
    V value;

    Pair(K k,V v){
        key = k;
        value = v;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}

class MapPairGenerator implements Generator<Pair<String,String>>{

    int index;
    @Override
    public Pair<String, String> next() {
        index++;
        return new Pair("key"+index, "value"+index);
    }
}

class MapData<K,V> extends LinkedHashMap<K,V>{

    public MapData(Generator<Pair<K,V>> gen, int quantity){
        for (int i = 0; i < quantity; i++) {
            Pair<K, V> next = gen.next();
            this.put(next.key, next.value);
        }
    }

    public static <K,V> MapData<K,V> map(Generator<Pair<K,V>> gen, int quantity){
        return new MapData<>(gen, quantity);
    }
}


public class MapDataTest {

    public static void main(String[] args) {
        MapData<String, String> map = MapData.map(new MapPairGenerator(), 10);
        System.out.println(map);
    }
}
