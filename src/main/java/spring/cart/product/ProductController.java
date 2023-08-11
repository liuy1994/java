package spring.cart.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.cart.product.model.*;
import spring.cart.product.validator.CreateProductRequestValidator;

@RestController
public class ProductController {
    CreateProductRequestValidator createProductRequestValidator;
    public ProductController(CreateProductRequestValidator createProductRequestValidator) {
        this.createProductRequestValidator = createProductRequestValidator;
    }
    @GetMapping("/products")
    public ResponseEntity<ListProductResponse> listProducts() {
        return new ResponseEntity<>(new ListProductResponse(), HttpStatus.OK);
    }
    @GetMapping("/products/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable String productId) {
        return new ResponseEntity<>(new GetProductResponse(), HttpStatus.OK);
    }
    @PostMapping("/products")
    public ResponseEntity<GetProductResponse> createProduct(@RequestBody CreateProductRequest body) {
        if (!createProductRequestValidator.validate(body)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new GetProductResponse(), HttpStatus.OK);
    }
    @PutMapping("/products/{productId}")
    public ResponseEntity<GetProductResponse> updateProduct(@PathVariable String productId, @RequestBody UpdateProductRequest body) {
        return new ResponseEntity<>(new GetProductResponse(), HttpStatus.OK);
    }
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String productId) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
