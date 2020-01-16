package no20100116.lambda;

/**
 * 定义Product
 *
 */
public class Product{
    String product;

    public Product(String productName){
        this.product = productName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product='" + product + '\'' +
                '}';
    }
}