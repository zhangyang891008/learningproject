package no20100116.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * consumer
 */
public class ComsumerTest {

    public static Consumer<List<Product>> getConsumerFunction(){
        return new Consumer<List<Product>>() {
            @Override
            public void accept(List<Product> products) {
                products.stream().forEach(System.out::println);
            }
        };
    }

    //produce ten product object
    public static List<Product> produce(){
        List<Product> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Product("product-"+i));
        }
        return list;
    }

    public static void main(String[] args) {
        List<Product> produce = produce();
        getConsumerFunction().accept(produce);
    }
}
