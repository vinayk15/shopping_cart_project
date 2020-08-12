package com.mindtree.shoppingcart.service;

import java.util.Optional;

import com.mindtree.shoppingcart.entity.Apparal;
import com.mindtree.shoppingcart.entity.Book;
import com.mindtree.shoppingcart.entity.Product;

public interface ProductService {

	public Optional<Product> findById(Long id);

	public void saveProduct(Product product);

	public void saveBook(Book book);

	public void saveApprel(Apparal apparal);

}
