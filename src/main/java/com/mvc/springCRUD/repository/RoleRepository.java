package com.mvc.springCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mvc.springCRUD.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {


    @Query("SELECT r FROM Role r WHERE r.name= ?1")
    public Role findByName(String name);

}
