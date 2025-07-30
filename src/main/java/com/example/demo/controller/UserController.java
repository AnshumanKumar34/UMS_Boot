package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService us;
	
	@PostMapping("/save")
	public User save(@RequestParam String name,@RequestParam String email,@RequestParam String password) {
		 User u=new User(0,name,email,password);
		return us.saveUser(u);
	}
	
	@GetMapping("/findAll")
	public List<User> findAll(){
		return us.findAllUser();
	}
	
	@GetMapping("/findById/{id}")
	public Optional<User> findById(@PathVariable Integer id) {
		return us.findUserById(id);
	}
	
    
}
