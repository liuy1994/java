package spring.cart.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.cart.product.model.Product;
import spring.cart.product.model.ProductDao;
import spring.cart.product.model.api.CreateProductRequest;
import spring.cart.product.model.api.GetProductResponse;
import spring.cart.product.model.api.ListProductResponse;
import spring.cart.product.model.api.UpdateProductRequest;
import spring.cart.product.validator.CreateProductRequestValidator;

@RestController
public class ProductController {
    CreateProductRequestValidator createProductRequestValidator;
    ProductDao productDao;
    public ProductController(CreateProductRequestValidator createProductRequestValidator, ProductDao productDao) {
        this.productDao = productDao;
        this.createProductRequestValidator = createProductRequestValidator;
    }
    @GetMapping("/products")
    public ResponseEntity<ListProductResponse> listProducts() {
        return new ResponseEntity<>(new ListProductResponse(), HttpStatus.OK);
    }
    @GetMapping("/products/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable String productId) {
        Product product = productDao.get(Integer.valueOf(productId));
        if (product == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(new GetProductResponse(product), HttpStatus.OK);
    }
    @PostMapping("/products")
    public ResponseEntity<GetProductResponse> createProduct(@RequestBody CreateProductRequest body) {
        if (!createProductRequestValidator.validate(body)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Product product = productDao.get(1);
        return new ResponseEntity<>(new GetProductResponse(product), HttpStatus.OK);
    }
    @PutMapping("/products/{productId}")
    public ResponseEntity<GetProductResponse> updateProduct(@PathVariable int productId, @RequestBody UpdateProductRequest body) {
        Product product = productDao.get(productId);
        return new ResponseEntity<>(new GetProductResponse(product), HttpStatus.OK);
    }
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String productId) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
