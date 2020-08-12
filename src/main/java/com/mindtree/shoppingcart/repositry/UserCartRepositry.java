package com.mindtree.shoppingcart.repositry;

import com.mindtree.shoppingcart.entity.UserCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserCartRepositry extends JpaRepository<UserCart, Long> {

	@Query("SELECT u from UserCart u where u.userId = :userId AND u.productId = :productId")
	Optional<UserCart> findUserByProduct(@Param("userId") Long userId, @Param("productId") Long productId);

	@Query("SELECT u from UserCart u where u.userId = :userId")
	List<UserCart> findUserCartByUserId(@Param("userId") Long userId);
}