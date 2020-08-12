package com.mindtree.shoppingcart.serviceImpl;

import com.mindtree.shoppingcart.common.RecordNotFoundException;
import com.mindtree.shoppingcart.entity.Product;
import com.mindtree.shoppingcart.entity.UserCart;
import com.mindtree.shoppingcart.entity.UserCartTotalAmount;
import com.mindtree.shoppingcart.repositry.UserCartRepositry;
import com.mindtree.shoppingcart.service.ProductService;
import com.mindtree.shoppingcart.service.UserCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

@Service
public class UserCartServiceImpl implements UserCartService {
	@Autowired
	UserCartRepositry cartRepository;
	@Autowired
	UserCartService userCartService;

	@Autowired
	ProductService productService;

	private static DecimalFormat df = new DecimalFormat("0.00");

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addUserCart(UserCart userCart) {
		int quantity = 0;
		long cartId;
		Optional<UserCart> cartInfo = userCartService.findByUserProduct(userCart.getUserId(), userCart.getProductId());

		if (cartInfo.isPresent()) {
			quantity = cartInfo.get().getQuantity();
			cartId = cartInfo.get().getUserCartId();
			userCart.setUserCartId(cartId);
		}
		Optional<Product> productInfo = productService.findById(userCart.getProductId());
		if (productInfo.isPresent()) {
			quantity = userCart.getQuantity() + quantity;
			userCart.setTotalPrice(productInfo.get().getPrice() * quantity);
			userCart.setQuantity(quantity);
			cartRepository.save(userCart);
		} else {

			throw new RecordNotFoundException("Record Not Found " + userCart.getProductId());
		}

	}

	@Override
	public List<UserCart> getUserCart() {
		return cartRepository.findAll();
	}

	@Override
	public Optional<UserCart> findById(Long cartId) {
		return cartRepository.findById(cartId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public String deleteById(Long cartId, int reqQuantity) {

		Optional<UserCart> cartDetails = userCartService.findById(cartId);
		UserCart cart = cartDetails.get();
		int dbQuantity = cartDetails.get().getQuantity();

		Optional<Product> productInfo = productService.findById(cartDetails.get().getProductId());
		if (!productInfo.isPresent()) {
			throw new RecordNotFoundException("Record Not Found " + cartDetails.get().getProductId());
		}
		if (reqQuantity == dbQuantity) {
			cartRepository.deleteById(cartId);
			return "Deleted Successfully";
		}

		if (dbQuantity < reqQuantity) {
			return "Not Valid Quantity";
		}

		int tempQuantity = dbQuantity - reqQuantity;
		Double totalPrice = productInfo.get().getPrice() * tempQuantity;
		cart.setQuantity(tempQuantity);
		cart.setTotalPrice(totalPrice);
		cartRepository.save(cart);
		return "Deleted Successfully";
	}

	@Override
	public Optional<UserCart> findByUserId(Long userId) {
		return cartRepository.findById(userId);
	}

	@Override
	public Optional<UserCart> findByUserProduct(Long userId, Long productId) {
		return cartRepository.findUserByProduct(userId, productId);
	}

	@Override
	public UserCartTotalAmount findUserCartByUserId(Long userId) {
		UserCartTotalAmount userCartTotalAmount = new UserCartTotalAmount();
		List<UserCart> carts = cartRepository.findUserCartByUserId(userId);
		if (carts.isEmpty()) {
			throw new RecordNotFoundException("Cart is empty");
		}
		Double totalAmt = 0.0;
		for (UserCart userCart : carts) {
			totalAmt += userCart.getTotalPrice();

		}
		userCartTotalAmount.setTotalAmount(Double.parseDouble(df.format(totalAmt)));
		userCartTotalAmount.setUserCart(carts);
		return userCartTotalAmount;
	}

}
