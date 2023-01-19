package com.vitoria.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitoria.models.Users;

public interface UserRepository extends JpaRepository<Users, Integer>{
	
	public Optional<Users> findByLogin(String login);

}
