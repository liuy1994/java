package spring.mall.web.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.mall.web.common.Result;
import spring.mall.web.product.controller.validator.CreateProductRequestValidator;
import spring.mall.web.product.model.Product;
import spring.mall.web.product.model.ProductDao;
import spring.mall.web.product.view.*;

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
    public ResponseEntity<Result<ListProductResponse>> listProducts() {
        List<Product> products = productDao.findAll();
        return new ResponseEntity<>(new Result(new ListProductResponse(products)), HttpStatus.OK);
    }
    @GetMapping("/products/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable String productId) {
        Product product = productDao.findById(Integer.parseInt(productId));
        if (product == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(new GetProductResponse(product), HttpStatus.OK);
    }
    @PostMapping("/products")
    public ResponseEntity<Result<CreateProductResponse>> createProduct(@RequestBody CreateProductRequest createProductRequest) {
        boolean valid = createProductRequestValidator.validate(createProductRequest);
        if (!valid) {
            return new ResponseEntity<>(new Result("字段校验不通过"), HttpStatus.OK);
        }
        Product product = productDao.save(new Product(createProductRequest.getName(), createProductRequest.getDescription(), createProductRequest.getPrice()));
        return new ResponseEntity<>(new Result(new CreateProductResponse(product)), HttpStatus.OK);
    }
    @PutMapping("/products/{productId}")
    public ResponseEntity<Result<GetProductResponse>> updateProduct(@PathVariable int productId, @RequestBody UpdateProductRequest updateProductRequest) {
        boolean valid = createProductRequestValidator.validate(updateProductRequest);
        if (!valid) {
            return new ResponseEntity<>(new Result("字段校验不通过"), HttpStatus.OK);
        }
        Product product = productDao.getById(productId);
        product.setDescription(updateProductRequest.getDescription());
        product.setName(updateProductRequest.getName());
        product.setPrice(updateProductRequest.getPrice());
        Product newProduct = productDao.save(product);
        return new ResponseEntity<>(new Result(newProduct), HttpStatus.OK);
    }
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Result<Void>> deleteProduct(@PathVariable Integer productId) {
        boolean exists = productDao.existsById(productId);
        if (!exists) {
            return new ResponseEntity<>(new Result<>("商品不存在"), HttpStatus.OK);
        }
        productDao.deleteById(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
