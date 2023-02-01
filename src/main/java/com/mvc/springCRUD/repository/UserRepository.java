package com.mvc.springCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.mvc.springCRUD.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u from User u Where u.username = :username")
	public User getUserByUsername(@Param("username") String username);


	@Query("SELECT u from User u Where u.id = :id")
	public User findByUserId(@Param("id") Long id);

}
