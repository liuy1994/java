package spring.cart.product.model;

public class UpdateProductRequest extends Product {
    public UpdateProductRequest(String id, String name, String description, long price) {
        super(id, name, description, price);
    }
}
