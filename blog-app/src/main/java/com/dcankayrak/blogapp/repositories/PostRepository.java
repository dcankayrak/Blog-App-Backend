package com.dcankayrak.blogapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dcankayrak.blogapp.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
	List<Post> findByCategoryId(int categoryId);
}
