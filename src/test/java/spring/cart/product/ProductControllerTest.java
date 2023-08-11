package spring.cart.product;

import org.easymock.EasyMock;
import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import spring.cart.product.model.GetProductResponse;
import spring.cart.product.validator.CreateProductRequestValidator;

import static org.junit.Assert.assertEquals;


public class ProductControllerTest extends EasyMockSupport {
    private ProductController productController;


    @Before
    public void setUp() {
        productController = new ProductController(new CreateProductRequestValidator());
    }

    @Test
    public void getProduct() {
        ResponseEntity<GetProductResponse> response = productController.getProduct(EasyMock.anyString());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
