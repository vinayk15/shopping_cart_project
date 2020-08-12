package com.mindtree.shoppingcart.service;

import java.util.List;
import java.util.Optional;

import com.mindtree.shoppingcart.entity.UserCart;
import com.mindtree.shoppingcart.entity.UserCartTotalAmount;

public interface UserCartService {

	public void addUserCart(UserCart userCart);

	public List<UserCart> getUserCart();

	public Optional<UserCart> findById(Long cartId);

	public String deleteById(Long cartId, int reqQuantity);

	public Optional<UserCart> findByUserId(Long userId);

	public Optional<UserCart> findByUserProduct(Long userId, Long productId);

	public UserCartTotalAmount findUserCartByUserId(Long userId);
}