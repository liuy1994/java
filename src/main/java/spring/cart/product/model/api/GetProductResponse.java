package spring.cart.product.model.api;
import spring.cart.product.model.Product;

public class GetProductResponse {
    final Product product;
    public GetProductResponse(Product product) {
        this.product = product;
    }
}
