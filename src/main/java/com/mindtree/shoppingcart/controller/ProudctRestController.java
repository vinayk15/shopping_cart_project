package com.mindtree.shoppingcart.controller;

import com.mindtree.shoppingcart.entity.Product;
import com.mindtree.shoppingcart.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/product/v1")
public class ProudctRestController {
	private static final Logger logger = LoggerFactory.getLogger(ProudctRestController.class);
	@Autowired
	ProductService productService;

	@RequestMapping(value = "/findByProductId")
	public Optional<Product> findByProductId(@RequestParam("productId") Long productID) {
		logger.info("Enter findByProductId " + productID);
		return productService.findById(productID);

	}

}
