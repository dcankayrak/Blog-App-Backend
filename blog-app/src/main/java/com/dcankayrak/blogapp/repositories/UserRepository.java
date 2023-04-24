package com.dcankayrak.blogapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcankayrak.blogapp.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
}
