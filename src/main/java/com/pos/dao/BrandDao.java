package com.pos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.pos.config.*;
import com.pos.domain.Brands;

@Repository
public class BrandDao {
    
	 public List<Brands> list() {
	        Session session = null;
	        try {
	            session = HibernateUtil.getSession();
	            Query query = session.createQuery("from Brands b");
	 
	            List queryList = query.list();
	            if (queryList != null && queryList.isEmpty()) {
	                return null;
	            } else {
	                System.out.println("list " + queryList);
	                return (List<Brands>) queryList;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            session.close();
	        }
	}
	 
	 public Brands findBrandById(int id) {
	        Session session = null;
	        try {
	            session = HibernateUtil.getSession();
	            Query query = session.createQuery("from Brands b where b.braId = :id");
	            query.setParameter("id", id);
	 
	            List queryList = query.list();
	            if (queryList != null && queryList.isEmpty()) {
	                return null;
	            } else {
	                return (Brands) queryList.get(0);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            session.close();
	        }
	    }
	 
	    public void updateBrand(Brands brand) {
	        Session session = null;
	        try {
	            session = HibernateUtil.getSession();
	            session.saveOrUpdate(brand);
	            session.flush();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	    }
	 
	    public Brands addBrand(Brands brand) {
	        Session session = null;
	        Transaction transaction = null;
	        try {
	            session = HibernateUtil.getSession();
	            System.out.println("session : "+session);
	            transaction = session.beginTransaction();
	            session.save(brand);
	            transaction.commit();
	            return brand;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	 
	    public void deleteBrand(int id) {
	        Session session = null;
	        try {
	            session = HibernateUtil.getSession();
	            Transaction beginTransaction = session.beginTransaction();
	            Query createQuery = session.createQuery("delete from Brands b where b.braId =:id");
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
