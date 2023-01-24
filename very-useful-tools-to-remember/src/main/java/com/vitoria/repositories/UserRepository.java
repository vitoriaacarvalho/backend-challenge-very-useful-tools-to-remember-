package com.vitoria.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vitoria.models.Users;
@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	
	public Optional<Users> findByLogin(String login);
	public Optional<Users> findByEmail(String email);
	@Query("SELECT u from Users u JOIN FETCH u.role where u.login = :username ")
	Users findByUsernameFetchRoles(@Param("username") String username);

}
