package com.infortech.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infortech.dao.ProductDao;
import com.infortech.entity.Product;
import com.infortech.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;

	@Override
	public boolean saveProduct(Product product) {

		return dao.saveProduct(product);
	}

	@Override
	public Product getProductById(long productId) {
		return dao.getProductById(productId);
	}

	@Override
	public List<Product> getAllProducts() {
		return dao.getAllProducts();
	}

	@Override
	public boolean deleteProductById(long productId) {
		return dao.deleteProductById(productId);
	}

	@Override
	public boolean updateProduct(Product product) {
		return dao.updateProduct(product);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
