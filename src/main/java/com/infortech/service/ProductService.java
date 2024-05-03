package com.infortech.service;

import java.util.List;

import com.infortech.entity.Product;

public interface ProductService {
	public boolean saveProduct(Product product);

	public Product getProductById(long productId);

	public List<Product> getAllProducts();

	public boolean deleteProductById(long productId);

	public boolean updateProduct(Product product);

	public List<Product> findAll();

	


}
