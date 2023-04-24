package com.dcankayrak.blogapp.business.abstracts;

import java.util.List;

import com.dcankayrak.blogapp.entities.Post;
import com.dcankayrak.blogapp.requests.PostCreateRequest;
import com.dcankayrak.blogapp.requests.PostUpdateRequest;

public interface PostService {
	List<Post> getAllPosts();
	Post getPost(int id);
	Post createPost(PostCreateRequest postRequest);
	Post updatePost(int id,PostUpdateRequest thePost);
	void deletePost(int id);
	List<Post> findByCategoryId(int categoryId);
}
