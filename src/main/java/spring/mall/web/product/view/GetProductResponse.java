package spring.mall.web.product.view;
import spring.mall.web.product.model.Product;

public class GetProductResponse {
    final Product product;
    public GetProductResponse(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
