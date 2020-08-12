package com.mindtree.shoppingcart.serviceImpl;

import com.mindtree.shoppingcart.entity.User;
import com.mindtree.shoppingcart.repositry.UserRespositry;
import com.mindtree.shoppingcart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRespositry userResp;

	@Override
	public void saveUser(User user) {
		userResp.save(user);
	}

	@Override
	public List<User> getUser() {
		return userResp.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
		return userResp.findById(id);
	}

	@Override
	public void deleteById(Long id) {
		userResp.deleteById(id);

	}

}
