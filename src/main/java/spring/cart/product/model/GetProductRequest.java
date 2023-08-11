package spring.cart.product.model;

public class GetProductRequest extends Product {
    public GetProductRequest(String id, String name, String description, long price) {
        super(id, name, description, price);
    }
}
