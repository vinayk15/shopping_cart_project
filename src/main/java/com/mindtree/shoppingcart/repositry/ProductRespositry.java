package com.mindtree.shoppingcart.repositry;

import com.mindtree.shoppingcart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRespositry extends JpaRepository<Product, Long> {

}
