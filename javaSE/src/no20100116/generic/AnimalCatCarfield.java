package no20100116.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * super extend 通配符，向上转型 向下转型
 */
public class AnimalCatCarfield {

    public static void main(String[] args) {
        List<Animal> animal = new ArrayList<Animal>();
        List<Cat> cat = new ArrayList<Cat>();
        List<Garfield> garfield = new ArrayList<Garfield>();

        animal.add(new Animal());
        cat.add(new Cat());
        garfield.add(new Garfield());


        //2.赋值操作测试
        //List<? extends Cat> extendsCatFromAnimal = animal;
        List<? super Cat> superCatFromAnimal = animal;

        List<? extends Cat> extendsCatFromCat = cat;
        List<? super Cat> superCatFromCat = cat;

        List<? extends Cat> extendsCatFromGarfield = garfield;
        //compile error
        //List<? super Cat> superCatFromGarfield = garfield;

        //3.测试add方法
        /*
        extendsCatFromCat.add(new Animal());
        extendsCatFromCat.add(new Cat());
        extendsCatFromCat.add(new Garfield());
        */

        // 只有Cat和子类可以添加到容器中。
        //superCatFromCat.add(new Animal());
        superCatFromCat.add(new Cat());
        superCatFromCat.add(new Garfield());

        // 4.测试get方法：
        Object cat1 = extendsCatFromCat.get(0);
        Cat cat2 = extendsCatFromCat.get(0);
        //虽然是讲一个garfield赋值给cat集合，但是类型擦除以后，是不知道具体类型的，下界就是Cat
        Cat cat3 = extendsCatFromGarfield.get(0);

    }
}
