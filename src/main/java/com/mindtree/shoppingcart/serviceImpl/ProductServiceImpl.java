package com.mindtree.shoppingcart.serviceImpl;

import com.mindtree.shoppingcart.common.RecordNotFoundException;
import com.mindtree.shoppingcart.entity.Apparal;
import com.mindtree.shoppingcart.entity.Book;
import com.mindtree.shoppingcart.entity.Product;
import com.mindtree.shoppingcart.repositry.ApparelRepository;
import com.mindtree.shoppingcart.repositry.BookRespositry;
import com.mindtree.shoppingcart.repositry.ProductRespositry;
import com.mindtree.shoppingcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRespositry productRespositry;
	@Autowired
	BookRespositry bookRespositry;
	@Autowired
	ApparelRepository apprealRespositry;

	@Override
	public Optional<Product> findById(Long id) {
		Optional<Product> productDetails = productRespositry.findById(id);

		if (!productDetails.isPresent()) {
			throw new RecordNotFoundException("Record not Found " + id);
		}

		return productDetails;
	}

	@Override
	public void saveProduct(Product product) {

		productRespositry.save(product);
	}

	@Override
	public void saveBook(Book book) {
		bookRespositry.save(book);

	}

	@Override
	public void saveApprel(Apparal apparal) {
		apprealRespositry.save(apparal);
	}

}
