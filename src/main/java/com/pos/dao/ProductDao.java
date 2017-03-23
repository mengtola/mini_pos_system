package com.pos.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.pos.config.*;
import com.pos.domain.Categories;
import com.pos.domain.Products;

@Repository
public class ProductDao {
    
	 public List<Products> list() {
	        Session session = null;
	        try {
	            session = HibernateUtil.getSession();
	            Query query = session.createQuery("from Products p where p.proActive = 1");
	 
	            List queryList = query.list();
	            if (queryList != null && queryList.isEmpty()) {
	                return null;
	            } else {
	                System.out.println("list " + queryList);
	                return (List<Products>) queryList;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            session.close();
	        }
	}
	 
	@SuppressWarnings("unchecked")
	@Transactional
	 public List<Products> list(Integer offset, Integer maxResults){
		return HibernateUtil.getSession()
				.createCriteria(Products.class)
				.setFirstResult(offset!=null?offset:0)
				.setMaxResults(maxResults!=null?maxResults:10)
				.list();
	}
	
	
	public Long count(){
		return (Long)HibernateUtil.getSession()
				.createCriteria(Products.class)
				.setProjection(Projections.rowCount())
				.uniqueResult();
	}
		
	 
	 public Products findProductById(int id) {
	        Session session = null;
	        try {
	            session = HibernateUtil.getSession();
	            Query query = session.createQuery("from Products p where p.proId = :id");
	            query.setParameter("id", id);
	 
	            List queryList = query.list();
	            if (queryList != null && queryList.isEmpty()) {
	                return null;
	            } else {
	                return (Products) queryList.get(0);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            session.close();
	        }
	    }
	 
	    public void updateProduct(Products product) {
	        Session session = null;
	        Transaction transaction = null;
	        try {
	            session = HibernateUtil.getSession();
	            transaction = session.beginTransaction();
	            session.saveOrUpdate(product);
	            session.flush();
	            transaction.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	    }
	 
	    public Products addProduct(Products product) {
	        Session session = null;
	        Transaction transaction = null;
	        try {
	            session = HibernateUtil.getSession();
	            System.out.println("session : "+session);
	            transaction = session.beginTransaction();
	            session.save(product);
	            transaction.commit();
	            return product;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	 
	    public void deleteProduct(int id) {
	        Session session = null;
	        try {
	            session = HibernateUtil.getSession();
	            Transaction beginTransaction = session.beginTransaction();
	            Query createQuery = session.createQuery("delete from Products p where p.proId =:id");
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
