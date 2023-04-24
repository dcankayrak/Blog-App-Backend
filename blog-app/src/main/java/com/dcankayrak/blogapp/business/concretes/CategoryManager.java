package com.dcankayrak.blogapp.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcankayrak.blogapp.business.abstracts.CategoryService;
import com.dcankayrak.blogapp.entities.Category;
import com.dcankayrak.blogapp.repositories.CategoryRepository;

@Service
public class CategoryManager implements CategoryService{
	
	private CategoryRepository theCategoryRepository;
	
	@Autowired
	public CategoryManager(CategoryRepository theCategoryRepository) {
		this.theCategoryRepository = theCategoryRepository;
	}

	@Override
	public List<Category> getCategories() {
		return this.theCategoryRepository.findAll();
	}

	@Override
	public Category createCategory(Category theCategory) {
		return this.theCategoryRepository.save(theCategory);
	}

	@Override
	public Category updateCategory(int id,Category theCategory) {
		Category tempCategory = this.theCategoryRepository.findById(id).orElse(null);
		if(tempCategory != null) {
			tempCategory.setName(theCategory.getName());
			return this.theCategoryRepository.save(tempCategory);
		}
		return null;
	}

	@Override
	public void deleteCategory(int id) {
		if(this.theCategoryRepository.findById(id).isPresent()) {
			this.theCategoryRepository.deleteById(id);
		}
	}

	@Override
	public Category getCategory(int id) {
		Category foundCategory = this.theCategoryRepository.findById(id).orElse(null);
		if(foundCategory != null) {
			return foundCategory;
		}
		return null;
	}
	
}
