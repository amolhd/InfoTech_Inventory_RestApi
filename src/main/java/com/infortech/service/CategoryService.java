package com.infortech.service;

import java.util.List;

import com.infortech.entity.Category;

public interface CategoryService {
	
	public boolean saveCategory(Category category);
	public Category getCategoryById(long id);
	public List<Category> getAllCategory();
	public boolean updateCategory(Category category);
	public boolean deleteCategory(long categoryId);
	

}
