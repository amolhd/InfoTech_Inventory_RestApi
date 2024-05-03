package com.infortech.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.infortech.entity.Product;
import com.infortech.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	
		

	//localhost:8080/product/products/2
	//get one product	
	@GetMapping(value = "/products/{id}")
	public Product getProductById(@PathVariable long id) 
	{
		Product product = service.getProductById(id);
		return product;
	}
	
	//localhost:8080/product/all-product
	//get all product
	@GetMapping(value = "/all-product")
	public List<Product> getAllProduct() 
	{
		List<Product> list = service.getAllProducts();
		return list;
	}
	
	//localhost:8080/product/add-product
	//add product by post
	@PostMapping(value = "/add-product")
	@ResponseStatus(code=HttpStatus.CREATED)
	public boolean createProduct(@RequestBody Product product){
		boolean isAdded = service.saveProduct(product);
		return isAdded;
	}
	
	//localhost:8080/product/delete-product-by-id/1
	//delete product by id
	@DeleteMapping("/delete-product-by-id/{productId}")
	public boolean deleteProduct(@PathVariable long productId)
	{
		boolean isDeleted = service.deleteProductById(productId);
		return isDeleted;
	}

	
	@PutMapping("/update-product")
	public boolean updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	


}
