package spring.cart.product.model;

public class CreateProductResponse extends Product {

    public CreateProductResponse(String id, String name, String description, long price) {
        super(id, name, description, price);
    }
}
