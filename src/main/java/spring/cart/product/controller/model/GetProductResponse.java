package spring.cart.product.controller.model;
import spring.cart.product.model.Product;

public class GetProductResponse {
    final Product product;
    public GetProductResponse(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
