package com.mindtree.shoppingcart.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "product")
public class Product implements Serializable, Comparable<Product> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserCart cart;


    public Product() {
        super();
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public UserCart getCart() {
        return cart;
    }

    public void setCart(UserCart cart) {
        this.cart = cart;
    }

    public Product(String productName, double price) {
        super();
        this.productName = productName;
        this.price = price;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                Objects.equals(productId, product.productId) &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(cart, product.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, price, cart);
    }

    @Override
    public int compareTo(Product product) {
        return this.getProductId().compareTo(product.productId);
    }
}
