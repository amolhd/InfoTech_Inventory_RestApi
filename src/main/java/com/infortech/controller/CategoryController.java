package com.infortech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.infortech.entity.Category;
import com.infortech.service.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

	@Autowired
	private CategoryService service;

		//localhost:8080/category/get-all-category
		//get all category with product
		@GetMapping(value = "/get-all-category")
		public List<Category> getAllCategory() {
		List<Category> list = service.getAllCategory();
		return list;
		}
	
		//localhost:8080/category/get-category-by-id/2
		//get category by id
		@GetMapping(value = "/get-category-by-id/{id}")
		public Category getCategoryById(@PathVariable int id) 
		{
			Category category = service.getCategoryById(id);
			return category;
		}
	
	
		//localhost:8080/category/add-category
		//add category by post
		@PostMapping(value = "/add-category")
		@ResponseStatus(code=HttpStatus.CREATED)
		public boolean createCategory(@RequestBody Category category)
		{
			boolean isAdded = service.saveCategory(category);
			return isAdded;
		}
	
		//localhost:8080/category/delete-category-by-id/1
		// delete category by id
		@DeleteMapping("/delete-category-by-id/{categoryId}")
		public boolean deleteCategory(@PathVariable long categoryId) 
		{
			boolean isDeleted = service.deleteCategory(categoryId);
			return isDeleted;
		}

		//localhost:8080/category/update-category
		//update(put) category by id
		@PutMapping("/update-category")
		public boolean updateCategory(@RequestBody Category category)
		{
			return service.updateCategory(category);
		}

}
