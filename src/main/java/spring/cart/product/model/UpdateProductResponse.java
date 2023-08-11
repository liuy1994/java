package spring.cart.product.model;

public class UpdateProductResponse extends Product {
    public UpdateProductResponse(String id, String name, String description, long price) {
        super(id, name, description, price);
    }
}