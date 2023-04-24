package com.dcankayrak.blogapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcankayrak.blogapp.business.abstracts.CommentService;
import com.dcankayrak.blogapp.entities.Comment;
import com.dcankayrak.blogapp.requests.CommentCreateRequest;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
	
	private CommentService theCommentService;

	@Autowired
	public CommentController(CommentService theCommentService) {
		this.theCommentService = theCommentService;
	}
	
	@GetMapping("/")
	public List<Comment> getComments(){
		return this.theCommentService.getComments();
	}
	
	@GetMapping("/{commentId}")
	public Comment getComments(@PathVariable int id){
		return this.theCommentService.getComment(id);
	}
	
	@GetMapping("/post/{postId}")
	public List<Comment> getCommentsWithPostId(@PathVariable int postId){
		return this.theCommentService.getCommentsWithPostId(postId);
	}
	
	@PostMapping("/")
	public Comment createComment(@RequestBody CommentCreateRequest request){
		return this.theCommentService.createComment(request);
	}
	
	@DeleteMapping("/{commentId}")
	public void deleteComment(@PathVariable int commentId) {
		this.theCommentService.deleteComment(commentId);
	}
	
	
}
