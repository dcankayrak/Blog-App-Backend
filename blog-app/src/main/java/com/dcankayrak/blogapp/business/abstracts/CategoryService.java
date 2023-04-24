package com.dcankayrak.blogapp.business.abstracts;

import java.util.List;

import com.dcankayrak.blogapp.entities.Category;

public interface CategoryService {
	List<Category> getCategories();
	Category getCategory(int id);
	Category createCategory(Category theCategory);
	Category updateCategory(int id,Category theCategory);
	void deleteCategory(int id);
}
