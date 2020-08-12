package com.mindtree.shoppingcart.repositry;

import com.mindtree.shoppingcart.entity.Apparal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApparelRepository extends JpaRepository<Apparal, Long> {

}
