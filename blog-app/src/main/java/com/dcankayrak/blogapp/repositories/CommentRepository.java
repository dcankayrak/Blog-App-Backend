package com.dcankayrak.blogapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dcankayrak.blogapp.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{
	
	//@Query("FROM Comment where post.id")
	//List<Comment> findByPost(int postId);
}
