package com.mindtree.shoppingcart.controller;

import com.mindtree.shoppingcart.entity.UserCart;
import com.mindtree.shoppingcart.entity.UserCartTotalAmount;
import com.mindtree.shoppingcart.service.ProductService;
import com.mindtree.shoppingcart.service.UserCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/cart/v1")
public class CartRestController {
    private static final Logger logger = LoggerFactory.getLogger(CartRestController.class);
    @Autowired
    UserCartService userCartService;

    @Autowired
    ProductService productService;


    @RequestMapping(value = "/addcart", method = RequestMethod.POST)
    public UserCartTotalAmount addCart(@RequestBody UserCart userCart) {
        logger.info("Entry addCart (){}");

        userCartService.addUserCart(userCart);
        return userCartService.findUserCartByUserId(userCart.getUserId());

    }
    /*
     *
     */

    @RequestMapping(value = "/deletecart", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCart(@RequestParam("cartId") Long cartId,
                                             @RequestParam("reqQuantity") int reqQuantity) {
        logger.info("Entry deleteCart (){}"+cartId);

        String msg = userCartService.deleteById(cartId, reqQuantity);
        logger.info("Deleted cart Id " + cartId);
        logger.info("Exit deleteCart (){}" + cartId);
        return new ResponseEntity<String>(msg, HttpStatus.OK);

    }
    /*
     *
     */

    @RequestMapping(value = "/cartview")
    public UserCartTotalAmount cartView(@RequestParam("userId") Long userId) {
        logger.info("Entry cartView (){}" + userId);
        return userCartService.findUserCartByUserId(userId);

    }

}
