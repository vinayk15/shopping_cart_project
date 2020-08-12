package com.mindtree.shoppingcart.service;

import java.util.List;
import java.util.Optional;

import com.mindtree.shoppingcart.entity.User;

public interface UserService {

	public void saveUser(User user);

	public List<User> getUser();

	public Optional<User> findById(Long id);

	public void deleteById(Long id);

}
