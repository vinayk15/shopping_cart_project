package com.mindtree.shoppingcart.repositry;

import com.mindtree.shoppingcart.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookRespositry extends JpaRepository<Book, Long> {

}
