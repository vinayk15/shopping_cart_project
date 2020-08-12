package com.mindtree.shoppingcart.repositry;

import com.mindtree.shoppingcart.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespositry extends JpaRepository<User, Long> {

}
