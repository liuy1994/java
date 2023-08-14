package spring.cart.product.model;

public class CreateProductRequest extends Product {
    public CreateProductRequest(String name, String description, long price) {
        super(name, description, price);
    }
}
