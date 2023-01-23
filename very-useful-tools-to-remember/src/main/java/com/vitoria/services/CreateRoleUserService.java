package com.vitoria.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vitoria.dto.CreateUserRoleDTO;
import com.vitoria.models.Roles;
import com.vitoria.models.Users;
import com.vitoria.repositories.UserRepository;

@Service
public class CreateRoleUserService {
	
	@Autowired
	private UserRepository repo;

	@Autowired
	private CreateUserRoleDTO createUserRoleDTO;
	
	public Users execute(CreateUserRoleDTO createUserRoleDTO) {
		Optional<Users> userExists=repo.findById(createUserRoleDTO.getIdUser());
		List<Roles> roles=new ArrayList<>();
		
		if (userExists.isEmpty()) {
			throw new Error("User does not exist");
		}
		roles=createUserRoleDTO.getIdsRoles().stream().map(role -> {
			return new Roles(role);
		}).collect(Collectors.toList());
		
		Users user=userExists.get();
		user.setRole(roles);
		
		repo.save(user);
		return user;	
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
