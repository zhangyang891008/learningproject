package no20191220;

import no20191220.entity.Apple;
import no20191220.entity.Banana;
import no20191220.entity.Fruit;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest {

    public void testList(){
        List<? extends Fruit> list = new ArrayList<Apple>();
        /* cannot compile
        list.add(new Apple());
        list.add(new Fruit());
        list.add(new Banana());
        */
        list.add(null);
        list.get(0);
    }
    public static void main(String[] args) {

    }
}
