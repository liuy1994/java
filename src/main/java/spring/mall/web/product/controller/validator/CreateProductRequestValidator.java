package spring.mall.web.product.controller.validator;

import org.springframework.stereotype.Component;
import spring.mall.web.product.view.CreateProductRequest;

@Component
public class CreateProductRequestValidator {
    public CreateProductRequestValidator() {
    }
    public boolean validate(CreateProductRequest request) {
        if (request == null) {
            return false;
        }
        if (request.getName().length() == 0) {
            return false;
        }
        if (request.getPrice() <= 0) {
            return false;
        }
        if (request.getDescription().length() > 255) {
            return false;
        }
        return true;
    }
}
