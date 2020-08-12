package com.mindtree.shoppingcart;

import com.mindtree.shoppingcart.entity.Apparal;
import com.mindtree.shoppingcart.entity.Book;
import com.mindtree.shoppingcart.entity.Product;
import com.mindtree.shoppingcart.entity.User;
import com.mindtree.shoppingcart.service.ProductService;
import com.mindtree.shoppingcart.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class ShoppingCartApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(ShoppingCartApplication.class);
	@Autowired
	ProductService productService;
	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApplication.class, args);
		logger.info("ShoppingCartApplication started{}");

	}

	@Override
	public void run(String... args) {

		User user = new User();
		user.setEmailId("Vinay.kulkarni@mindtree.com");
		user.setPassword("vinay");
		user.setUserName("vinay");
		userService.saveUser(user);

		Product product = new Product("Connecept of java", 399);
		Book book = new Book("Genre", "Vinay Authoure", "N/A", product);
		Apparal apparal = new Apparal("Book", "N/A", "N/A", product);

		Product product1 = new Product("Cloud Computing", 125000);
		Book book1 = new Book("Genre", "Greate Learning Authoure", "N/A", product);
		Apparal apparal1 = new Apparal("Book", "N/A", "N/A", product);

		Product product2 = new Product("Connecpt Of C", 100);
		Book book2 = new Book("Genre", "C authour", "N/A", product);
		Apparal apparal2 = new Apparal("Book", "N/A", "N/A", product);

		Product product3 = new Product("Amazon Web service", 70000);
		Book book3 = new Book("Genre", "David", "N/A", product);
		Apparal apparal3 = new Apparal("Online", "N/A", "N/A", product);

		Product product4 = new Product("Laptop", 400000);
		Book book4 = new Book("Electrical", "N/A", "N/A", product);
		Apparal apparal4 = new Apparal("Laptop", "Dell", "New-Design", product);

		productService.saveProduct(product);
		productService.saveBook(book);
		productService.saveApprel(apparal);

		productService.saveProduct(product1);
		productService.saveBook(book1);
		productService.saveApprel(apparal1);

		productService.saveProduct(product2);
		productService.saveBook(book2);
		productService.saveApprel(apparal2);

		productService.saveProduct(product3);
		productService.saveBook(book3);
		productService.saveApprel(apparal3);

		productService.saveProduct(product4);
		productService.saveBook(book4);
		productService.saveApprel(apparal4);

	}

}
