package no20100116.lambda;

import java.util.function.Supplier;

/**
 * Produce
 */
public class SupplierTest {

    public static Integer number = 0;

    public static Supplier<Product> getProduct(){
        return new Supplier<Product>() {
            @Override
            public Product get() {
                return new Product("product"+number++);
            }
        };
    }

    public static void main(String[] args) {
        Supplier<Product> producer = getProduct();
        System.out.println(producer.get());
    }
}
