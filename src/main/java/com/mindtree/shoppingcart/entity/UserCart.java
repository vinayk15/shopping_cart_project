package com.mindtree.shoppingcart.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usercart")
public class UserCart implements Serializable, Comparable<UserCart> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userCartId;
    private Long userId;
    private Long productId;
    private Double totalPrice;
    private int quantity;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<Product> productList;

    public Long getUserCartId() {
        return userCartId;
    }

    public void setUserCartId(Long userCartId) {
        this.userCartId = userCartId;
    }

    public void setUserCartId(long userCartId) {
        this.userCartId = userCartId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCart userCart = (UserCart) o;
        return userCartId == userCart.userCartId &&
                quantity == userCart.quantity &&
                Objects.equals(userId, userCart.userId) &&
                Objects.equals(productId, userCart.productId) &&
                Objects.equals(totalPrice, userCart.totalPrice) &&
                Objects.equals(productList, userCart.productList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userCartId, userId, productId, totalPrice, quantity, productList);
    }

    @Override
    public int compareTo(UserCart userCart) {
        return this.getUserCartId().compareTo(userCart.getUserCartId());
    }
}
