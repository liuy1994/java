package spring.cart.product;

import org.easymock.EasyMock;
import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import spring.cart.product.model.ProductDao;
import spring.cart.product.model.api.GetProductResponse;
import spring.cart.product.validator.CreateProductRequestValidator;
import spring.cart.util.StatementFactory;

import java.sql.Statement;

import static org.junit.Assert.assertEquals;

//
//public class ProductControllerTest extends EasyMockSupport {
//    private ProductController productController;
//
//
//    @Before
//    public void setUp() {
//        productController = new ProductController(new CreateProductRequestValidator(), new ProductDao(new StatementFactory()));
//    }
//
//    @Test
//    public void getProduct() {
//        ResponseEntity<GetProductResponse> response = productController.getProduct(EasyMock.anyInt());
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//    }
//}
