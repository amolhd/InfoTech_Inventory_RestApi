package com.infortech.daoIMPL;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infortech.dao.CategoryDao;
import com.infortech.entity.Category;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveCategory(Category category) {
		// Session session = null;
		boolean isAdded = false;
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();

			System.out.println("Hi this is "+ category);
			session.save(category);
			transaction.commit();
			isAdded = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isAdded;
	}

	@Override
	public Category getCategoryById(long id) {
		Category category = null;
		try {
			Session session = sessionFactory.openSession();
			category = session.get(Category.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return category;
	}

	

	@Override
	public List<Category> getAllCategory() {
		List<Category> list = null;
		try {
			Session session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Category.class);
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean updateCategory(Category category) {
		boolean isUpdated = false;
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.update(category);
			transaction.commit();
			isUpdated = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	@Override
	public boolean deleteCategory(long categoryId) {
		boolean isDeleted = false;
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Category category = session.get(Category.class, categoryId);

			if (category != null) {
				session.delete(category);
				transaction.commit();
				isDeleted = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

}
