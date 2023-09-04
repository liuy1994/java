package spring.mall.web.cart.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import spring.mall.util.JwtUtil;
import spring.mall.web.cart.model.CartItem;
import spring.mall.web.cart.model.CartItemDao;
import spring.mall.web.cart.view.ListCartItemResponse;
import spring.mall.web.common.Result;
import spring.mall.web.user.model.User;
import spring.mall.web.user.model.UserSimple;

import java.util.List;

import static spring.mall.config.Constant.SESSION_TOKEN;

@RestController
public class ItemController {
    CartItemDao cartItemDao;

    public ItemController(CartItemDao cartItemDao) {
        this.cartItemDao = cartItemDao;
    }

    @GetMapping("/cart")
    public ResponseEntity<Result<ListCartItemResponse>> cart(@RequestHeader(name = SESSION_TOKEN, defaultValue = "token") String token) {
        UserSimple userSimple = JwtUtil.parseToken(token);
        System.out.println(123);
        if (userSimple == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        List<CartItem> cartItems = cartItemDao.findByUserId(userSimple.getId());
        System.out.println(cartItems);
        return new ResponseEntity<>(new Result<>(new ListCartItemResponse(cartItems)), HttpStatus.OK);
    }
}
