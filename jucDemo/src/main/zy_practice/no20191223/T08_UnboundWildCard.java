package no20191223;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    8.无界通配符：很多情况下，编译器很少关心使用的是远程类型还是无界通配符，可以被认为是一种装饰。
    实际上，它是在声明："我是想用Java泛型编写这段代码，我这里不要用原生类型，但是在当前情况下，泛型参数可以持有任何类型"
    1.无界通配符的重要应用：当处理多个泛型参数时，有时允许一个参数可以是任何类型，同时为其他参数确定耨中特定类型。
    2.类型捕获转换
 */
public class T08_UnboundWildCard {

    static Map map1;
    static Map<?,?> map2;
    static Map<String,?> map3;

    static void assign1(Map map){
        map1 = map;
    }
    static void assign2(Map map){
        map2 = map;
    }
    static void assign3(Map map){
        map3 = map;
    }

    public static void main(String[] args) {
        //case1
        assign1(new HashMap());
        assign2(new HashMap());
        assign3(new HashMap()); //warning

        assign1(new HashMap<String,Integer>());
        assign2(new HashMap<String,Integer>());
        assign3(new HashMap<String,Integer>());

        //case2 转换捕获
        List<String> list = new ArrayList<>();
        list.add("test");
        CaptureConversion.f2(list);
    }

}

class CaptureConversion {
    static void f2(List<?> list) {
        f1(list);
    }

    static <T> void f1(List<T> list){
        T t = list.get(0);
        System.out.println(t.getClass().getSimpleName());
    }
}
