package spring.mall.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.mall.product.controller.model.*;
import spring.mall.product.controller.validator.CreateProductRequestValidator;
import spring.mall.product.model.Product;
import spring.mall.product.model.ProductDao;

import java.util.List;

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
        List<Product> products = productDao.findAll();
        return new ResponseEntity<>(new ListProductResponse(products), HttpStatus.OK);
    }
    @GetMapping("/products/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable String productId) {
        Product product = productDao.findById(Integer.parseInt(productId));
        if (product == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(new GetProductResponse(product), HttpStatus.OK);
    }
    @PostMapping("/products")
    public ResponseEntity<GetProductResponse> createProduct(@RequestBody CreateProductRequest body) {
        if (!createProductRequestValidator.validate(body)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Product product = productDao.save(body);
        return new ResponseEntity<>(new GetProductResponse(product), HttpStatus.OK);
    }
    @PutMapping("/products/{productId}")
    public ResponseEntity<GetProductResponse> updateProduct(@PathVariable int productId, @RequestBody UpdateProductRequest body) {
        Product product = productDao.getById(productId);
        return new ResponseEntity<>(new GetProductResponse(product), HttpStatus.OK);
    }
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String productId) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
