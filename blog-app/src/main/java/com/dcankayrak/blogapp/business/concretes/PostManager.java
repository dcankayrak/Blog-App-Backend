package com.dcankayrak.blogapp.business.concretes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcankayrak.blogapp.business.abstracts.PostService;
import com.dcankayrak.blogapp.entities.Category;
import com.dcankayrak.blogapp.entities.Post;
import com.dcankayrak.blogapp.repositories.CategoryRepository;
import com.dcankayrak.blogapp.repositories.PostRepository;
import com.dcankayrak.blogapp.requests.PostCreateRequest;
import com.dcankayrak.blogapp.requests.PostUpdateRequest;

@Service
public class PostManager implements PostService{
	
	private PostRepository thePostRepository;
	private CategoryRepository theCategoryRepository;
	
	@Autowired
	public PostManager(PostRepository thePostRepository,CategoryRepository theCategoryRepository) {
		this.thePostRepository = thePostRepository;
		this.theCategoryRepository = theCategoryRepository;
	}

	@Override
	public List<Post> getAllPosts() {
		return this.thePostRepository.findAll();
	}

	@Override
	public Post getPost(int id) {
		Optional<Post> thePost = this.thePostRepository.findById(id);
		if(thePost.isPresent()) {
			return thePost.get();
		}
		return null;
	}

	@Override
	public Post createPost(PostCreateRequest postRequest) {
		Post newPost = new Post();
		Category foundCategory = this.theCategoryRepository
				.findById(postRequest.getCategoryId()).orElse(null);
		if(foundCategory != null) {
			newPost.setTitle(postRequest.getTitle());
			newPost.setText(postRequest.getText());
			newPost.setCategory(foundCategory);
			newPost.setUploadDate(LocalDate.now());
			newPost.setImage(postRequest.getImage());
			
			return this.thePostRepository.save(newPost);
		}
		return null;
	}

	@Override
	public Post updatePost(int id,PostUpdateRequest thePost) {
		Optional<Post> foundPost = this.thePostRepository.findById(id);
		Optional<Category> foundCategory = this.theCategoryRepository.findById(thePost.getCategoryId());
		if(foundPost.isPresent() && foundCategory.isPresent()) {
			Post updatedPost = foundPost.get();
			updatedPost.setCategory(foundCategory.get());
			updatedPost.setTitle(thePost.getTitle());
			updatedPost.setText(thePost.getText());
			updatedPost.setUploadDate(LocalDate.now());
			updatedPost.setImage(thePost.getImage());
		}
		return null;
	}

	@Override
	public void deletePost(int id) {
		Optional<Post> thePost = this.thePostRepository.findById(id);
		if(thePost.isPresent()) {
			this.thePostRepository.deleteById(id);
		}
	}

	@Override
	public List<Post> findByCategoryId(int categoryId) {
		return this.thePostRepository.findByCategoryId(categoryId);
	}

}
