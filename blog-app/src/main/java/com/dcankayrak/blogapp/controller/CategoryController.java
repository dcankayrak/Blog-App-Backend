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

import com.dcankayrak.blogapp.business.abstracts.CategoryService;
import com.dcankayrak.blogapp.entities.Category;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	private CategoryService theCategoryService;
	
	
	@Autowired
	public CategoryController(CategoryService theCategoryService) {
		this.theCategoryService = theCategoryService;
	}

	@GetMapping("/")
	public List<Category> getAllPosts() {
		return this.theCategoryService.getCategories();
	}
	
	@GetMapping("/{categoryId}")
	public Category getPost(@PathVariable int categoryId) {
		return this.theCategoryService.getCategory(categoryId);
	}
	
	@PostMapping("/")
	public Category createCategory(@RequestBody Category newCategory) {
		return this.theCategoryService.createCategory(newCategory);
	}
	
	@PutMapping("/{categoryId}")
	public Category updateCategory(@PathVariable int postId,@RequestBody Category updateCategory) {
		return this.theCategoryService.updateCategory(postId, updateCategory);
	}
	
	@DeleteMapping("/{categoryId}")
	public void deletePost(@PathVariable int categoryId) {
		this.theCategoryService.deleteCategory(categoryId);
	}
}
