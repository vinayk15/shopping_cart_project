package com.mindtree.shoppingcart.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class UserCartTotalAmount implements Serializable,Comparable<UserCartTotalAmount> {

	private List<UserCart> userCart;

	private Double totalAmount;

	public List<UserCart> getUserCart() {
		return userCart;
	}

	public void setUserCart(List<UserCart> userCart) {
		this.userCart = userCart;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserCartTotalAmount that = (UserCartTotalAmount) o;
		return Objects.equals(userCart, that.userCart) &&
				Objects.equals(totalAmount, that.totalAmount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userCart, totalAmount);
	}

	@Override
	public int compareTo(UserCartTotalAmount userCartTotalAmount) {
		return 0;
	}
}
