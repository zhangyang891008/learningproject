package no20200115.linkedhashmap;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * linkedHashMap：是HashMap和双向链表的二合一
 * AccessOrder字段表示维持何种次序：false表示插入顺序；true表示访问顺序；默认是插入顺序，可以自定义
 *
 */
public class LinkedhashMapDemo {

    public static void fillMap(Map<String,String> map){
        for (int i = 0; i <10; i++) {
            map.put("key"+i, "value"+i);
        }
    }

    public static void main(String[] args) {

        System.out.println(null instanceof String);


        LinkedHashMap<String,String> map = new LinkedHashMap<>(20,0.75f, true);

        fillMap(map);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.toString());
        }

        System.out.println("******print******");

        //map.put("key5","changed!");
        map.get("key5");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.toString());
        }
        map.get("key9");
        System.out.println("****** get key9 ******");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.toString());
        }

    }
}
