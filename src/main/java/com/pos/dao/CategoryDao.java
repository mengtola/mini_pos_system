package com.pos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.pos.config.HibernateUtil;
import com.pos.domain.Categories;

@Repository
public class CategoryDao {
    
	 public List<Categories> list() {
	        Session session = null;
	        try {
	            session = HibernateUtil.getSession();
	            Query query = session.createQuery("from Categories c");
	 
	            List queryList = query.list();
	            if (queryList != null && queryList.isEmpty()) {
	                return null;
	            } else {
	                System.out.println("list " + queryList);
	                return (List<Categories>) queryList;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            session.close();
	        }
	}
	
	 
	 public Categories findCategoryById(int id) {
	        Session session = null;
	        try {
	            session = HibernateUtil.getSession();
	            Query query = session.createQuery("from Categories c where c.cat_id = :id");
	            query.setParameter("id", id);
	 
	            List queryList = query.list();
	            if (queryList != null && queryList.isEmpty()) {
	                return null;
	            } else {
	                return (Categories) queryList.get(0);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            session.close();
	        }
	    }
	 
	    public void updateCategory(Categories category) {
	        Session session = null;
	        try {
	            session = HibernateUtil.getSession();
	            session.saveOrUpdate(category);
	            session.flush();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	    }
	 
	    public Categories addCategory(Categories category) {
	        Session session = null;
	        Transaction transaction = null;
	        try {
	            session = HibernateUtil.getSession();
	            System.out.println("session : "+session);
	            transaction = session.beginTransaction();
	            session.save(category);
	            transaction.commit();
	            return category;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	 
	    public void deleteCategories(int id) {
	        Session session = null;
	        try {
	            session = HibernateUtil.getSession();
	            Transaction beginTransaction = session.beginTransaction();
	            Query createQuery = session.createQuery("delete from Categories c where c.cat_id =:id");
	            createQuery.setParameter("id", id);
	            createQuery.executeUpdate();
	            beginTransaction.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	    }
}
