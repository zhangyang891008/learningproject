package no20191223;

/*
    6.边界：重用了extends关键字
        边界可以用于泛型的参数类型上设置限制条件。可以按照自己的边界类型来调用方法。
        因为类型擦除，所以，可以用无界泛型参数调用的方法只是可以用Object调用的方法。
        如果将这个参数限制为限制为某个类型子集，就可以用这个类型子集来调用方法。
 */
public class T06_GenericBoundary {

    public static void main(String[] args) {
        People<Zhangyang> newPeople = new People<Zhangyang>(new Zhangyang());
        newPeople.Fly();
        newPeople.makeup();
    }
}

interface Fly{
    void fly();
}

interface ChangeFace{
    void makeup();
}

class Zhangyang implements ChangeFace, Fly{

    @Override
    public void fly() {
        System.out.println("zhangyang is flying...");
    }

    @Override
    public void makeup() {
        System.out.println("zhangyang is a beauty...");
    }
}

class People<T extends ChangeFace & Fly> {
    T x;
    public People(T people){
        x = people;
    }

    public void Fly(){
        x.fly();
    }

    public void makeup(){
        x.makeup();
    }
}