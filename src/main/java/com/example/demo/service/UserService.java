package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository ur;
	
	public User saveUser(User u) {
		return ur.save(u);
	}

	public List<User> findAllUser() {
		return ur.findAll();
	}
                                                                                                                               
	public Optional<User> findUserById(Integer id) {
		return ur.findById(id);
	}

}
