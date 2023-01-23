package com.vitoria.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitoria.models.Users;

public interface UserRepository extends JpaRepository<Users, UUID>{
	
	public Optional<Users> findByLogin(String login);
	public Optional<Users> findByEmail(String email);
	
}
