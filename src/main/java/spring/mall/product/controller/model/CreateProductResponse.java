package spring.mall.product.controller.model;
import spring.mall.product.model.Product;

public class CreateProductResponse {
    final Product product;

    public CreateProductResponse(Product product) {
        this.product = product;
    }
    public CreateProductResponse() {
        this.product = null;
    }


    public Product getProduct() {
        return product;
    }
}
