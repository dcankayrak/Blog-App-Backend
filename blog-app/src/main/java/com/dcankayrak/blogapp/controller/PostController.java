package com.dcankayrak.blogapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcankayrak.blogapp.business.abstracts.PostService;
import com.dcankayrak.blogapp.entities.Post;
import com.dcankayrak.blogapp.requests.PostCreateRequest;
import com.dcankayrak.blogapp.requests.PostUpdateRequest;

@RestController
@RequestMapping("/api/posts")
public class PostController {
	
	private PostService thePostService;
	
	@Autowired
	public PostController(PostService thePostService) {
		this.thePostService = thePostService;
	}

	@GetMapping("/")
	public List<Post> getAllPosts() {
		return this.thePostService.getAllPosts();
	}
	
	@GetMapping("/{postId}")
	public Post getPost(@PathVariable int postId) {
		return this.thePostService.getPost(postId);
	}
	
	@GetMapping("/category/{categoryId}")
	public List<Post> getPostsWithCategoryId(@PathVariable int categoryId) {
		return this.thePostService.findByCategoryId(categoryId);
	}
	
	@PostMapping("/")
	public Post createPost(@RequestBody PostCreateRequest newPost) {
		return this.thePostService.createPost(newPost);
	}
	
	@PutMapping("/{postId}")
	public Post updatePost(@PathVariable int postId,@RequestBody PostUpdateRequest updatePost) {
		return this.thePostService.updatePost(postId, updatePost);
	}
	
	@DeleteMapping("/{postId}")
	public void deletePost(@PathVariable int postId) {
		this.thePostService.deletePost(postId);
	}
}
