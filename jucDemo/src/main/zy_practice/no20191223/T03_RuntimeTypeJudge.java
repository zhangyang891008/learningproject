package no20191223;
/*
3.运行时类型判断：
       虚拟中没有泛型，虚拟机中的对象总有一个特定的非泛型类型。所有的类型查询只产生原始类型。
 */
public class T03_RuntimeTypeJudge {

    static class Raw<T>{
    }

    public static void main(String[] args) {
        Raw<String> stringRaw = new Raw<>();
        Raw<Integer> integerRaw = new Raw<>();

        //结果相等。
        System.out.println( stringRaw.getClass() == integerRaw.getClass());
    }

}
