package spring.cart.product.model;

public class CreateProductRequest extends Product {
    public CreateProductRequest(String id, String name, String description, long price) {
        super(id, name, description, price);
    }
}
