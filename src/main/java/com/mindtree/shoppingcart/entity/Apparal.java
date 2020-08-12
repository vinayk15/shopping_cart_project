package com.mindtree.shoppingcart.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "apparal")
public class Apparal implements Serializable, Comparable<Apparal> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long apparelId;
    public String type;
    public String brand;
    public String design;
    @OneToOne
    @JoinColumn(name = "productId")
    private Product product;

    public Long getApparelId() {
        return apparelId;
    }

    public void setApparelId(Long apparelId) {
        this.apparelId = apparelId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Apparal() {
        super();
    }

    public Apparal(String type, String brand, String design, Product product) {
        super();
        this.type = type;
        this.brand = brand;
        this.design = design;
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apparal apparal = (Apparal) o;
        return Objects.equals(apparelId, apparal.apparelId) &&
                Objects.equals(type, apparal.type) &&
                Objects.equals(brand, apparal.brand) &&
                Objects.equals(design, apparal.design) &&
                Objects.equals(product, apparal.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apparelId, type, brand, design, product);
    }

    @Override
    public int compareTo(Apparal apparal) {
        return this.getApparelId().compareTo(apparal.getApparelId());
    }
}
