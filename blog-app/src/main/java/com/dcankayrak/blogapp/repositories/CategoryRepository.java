package com.dcankayrak.blogapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcankayrak.blogapp.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
