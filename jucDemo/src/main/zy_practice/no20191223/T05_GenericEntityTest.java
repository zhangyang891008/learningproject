package no20191223;

import javax.management.relation.Relation;

/*
5.创建类型实例：
        不支持通过new创建实例的原因：1。类型擦除 2。编译器不能验证T具有默认无参构造器。
     解决方案：
        通过传递工厂对象来创建新的实例。
        1。反射：
            Class<T> kind;
            T x = kind.newInstance();
            有局限，例如Integer这种没有默认构造器的类无法创建对象。

        2。改进：显示工厂，并限定类型。
        3.模版方法
 */
public class T05_GenericEntityTest {

    public static void main(String[] args) {
        //test1:reflection way
        Reflection.ClassFactory<String> factory = new Reflection.ClassFactory<>(String.class);
        factory.x = "test";
        System.out.println("string:" + factory.x);

        /*

            Caused by: java.lang.NoSuchMethodException: java.lang.Integer.<init>()
                at java.lang.Class.getConstructor0(Class.java:3082)
                at java.lang.Class.newInstance(Class.java:412)
                ... 2 more
         */
        //Reflection.ClassFactory<Integer> factory1 = new Reflection.ClassFactory<>(Integer.class);

        //test2: improved factory
        Foo<String> stringFoo = new Foo<String>(new StringFactory());
        System.out.println("2:"+stringFoo.x);
        Foo<Integer> integerFoo = new Foo<Integer>(new IntegerFactory());
        System.out.println("2:"+integerFoo.x);

        //test3:template
        ConcreteCreater concreteCreater = new ConcreteCreater();
        concreteCreater.f();

    }
}

class Reflection{
    static class ClassFactory<T>{
        T x;
        public ClassFactory(Class<T> kind){
            try{
                x = kind.newInstance(); //局限性：仅限于有无参数构造器的对象适用。
            } catch(Exception e){
                throw new RuntimeException(e);
            }
        }
    }
}

//test2
interface FactoryI<T>{
    T create();
}

class Foo<T>{
    T x;
    public <F extends FactoryI<T>> Foo(F factory){
        x = factory.create();
    }
}

class IntegerFactory implements FactoryI<Integer>{
    @Override
    public Integer create() {
        return new Integer(0);
    }
}

class StringFactory implements FactoryI<String>{

    @Override
    public String create() {
        return new String();
    }
}

//test3:template

abstract class AbstractCreater<T>{
    final T t;
    public AbstractCreater(){
        t = create();
    }
    abstract T create();
}

class ConcreteCreater extends AbstractCreater<X>{

    @Override
    X create() {
        return new X();
    }

    public void f(){
        System.out.println("---"+ t.getClass().getSimpleName());
    }
}

class X{
}