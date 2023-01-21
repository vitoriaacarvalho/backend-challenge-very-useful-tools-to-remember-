package com.vitoria.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.vitoria.models.Users;
import com.vitoria.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository repo;
	
	
	@GetMapping
	public ResponseEntity<List<Users>> findAll(){
		List<Users> users=repo.findAll();
		return ResponseEntity.ok().body(users);
	}
	
	@PostMapping
	public ResponseEntity<Users> insert(@RequestBody Users user){
		//user.setPassword(encoder.getPasswordEncoder(user.getPassword()));
		Users entity=repo.save(user);
		return ResponseEntity.ok().body(entity);
	}
	
	@GetMapping("/emails")
	public ResponseEntity<Optional<Users>> findByEmail(@RequestParam String email){
		Optional<Users> user=repo.findByEmail(email);
		if(user==null) {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "This email does not exist. Please try again"
			);
		}
		return ResponseEntity.ok().body(user);
	}
	
	@GetMapping("/logins")
	public ResponseEntity<Optional<Users>> findByLogin(@RequestParam String login){
		Optional<Users> user=repo.findByLogin(login);
		if(user==null) {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "This user does not exist. Please try again"
			);
		}
		return ResponseEntity.ok().body(user);
	}
	
	@PutMapping("/update-password")
	public ResponseEntity<String> updatePassword(@PathVariable String email, @RequestBody Users user){
		Users updatedUser=repo.findByEmail(email).get();
		//updatedUser.setEmail(user.getEmail());
		//updatedUser.setLogin(user.getLogin());
		updatedUser.setPassword(user.getPassword());
		return ResponseEntity.ok().body("Password updated sucessfully!");
	}
	
	@PutMapping("/update-login")
	public ResponseEntity<String> updateLogin(@PathVariable String email, @RequestBody Users user){
		Users updatedUser=repo.findByEmail(email).get();
		updatedUser.setLogin(user.getLogin());
		return ResponseEntity.ok().body("Login updated sucessfully!");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
