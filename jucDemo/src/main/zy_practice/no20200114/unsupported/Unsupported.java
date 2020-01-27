package no20200114.unsupported;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 可选操作
 * 不支持会抛出UnsupportedOperationException
 *
 */
public class Unsupported {

    static void test(String msg, List<String> list){
        Collection<String> c = list;
        List<String> subList = list.subList(1, 2);
        Collection<String> c2 = new ArrayList<>(subList);
        //之前没有其他修改，所以可以修改，后面一次调用因为经过了其他的修改操作，所以不能再次执行set
        subList.set(0,"x");

        try{
            list.subList(1,2).add("XXXXX");
        } catch (Exception e){
            System.out.println("sublist add:"+e);
        }

        try{
            c.retainAll(c2);
            System.out.println("retainAll success");
        }catch (Exception e){
            System.out.println("retainAll:"+e) ;
        }

        try{
            c.removeAll(c2);
            System.out.println("removeAll success");
        }catch (Exception e){
            System.out.println("removeAll:"+e) ;
        }
        try{
            c.add("CCC");
        }catch (Exception e){
            System.out.println("collection add"+e);
        }

        try{
            c.remove("hello");
        }catch (Exception e){
            System.out.println("collection remove"+e);
        }

        try{
            subList.set(0,"x");
        }catch (Exception e){
            System.out.println("sublist set"+e);
        }

    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","world","tome","cat");
        test("msg",list);
    }
}
