package com.infortech.daoIMPL;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infortech.dao.ProductDao;
import com.infortech.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveProduct(Product product) {
				boolean isAdded = false;
				try{
					Session session = sessionFactory.openSession();
					Transaction transaction = session.beginTransaction();
					session.save(product);
					transaction.commit();
					isAdded = true;
				}  catch (Exception e) {
					System.out.println();
					e.printStackTrace();
				}
				
				return isAdded;
	}

	@Override
	public Product getProductById(long productId) {
		Product product = null;
		try  {
			Session session = sessionFactory.openSession();
			product = session.get(Product.class, productId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> list = null;
		try {
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			// 3 record per page

			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean deleteProductById(long productId) {
		boolean isDeleted = false;
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Product product = session.get(Product.class, productId);

			if (product != null) {
				session.delete(product);
				transaction.commit();
				isDeleted = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	@Override
	public boolean updateProduct(Product product) {
		boolean isUpdated = false;
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Product dbProduct = getProductById(product.getProductId());
			if(dbProduct!=null) {
				session.update(product);
				transaction.commit();
				isUpdated = true;
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	
}
