package com.vitoria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitoria.config.PasswordEncoder;
import com.vitoria.models.User;
import com.vitoria.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		List<User> users=repo.findAll();
		return ResponseEntity.ok().body(users);
	}
	
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user){
		user.setPassword(encoder.getPasswordEncoder(user.getPassword()));
		User entity=repo.save(
				user);
		return ResponseEntity.ok().body(entity);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
