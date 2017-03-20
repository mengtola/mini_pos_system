package com.pos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.pos.config.*;
import com.pos.domain.Customers;

@Repository
public class CustomerDao {
    
	 public List<Customers> list() {
	        Session session = null;
	        try {
	            session = HibernateUtil.getSession();
	            Query query = session.createQuery("from Customers c");
	 
	            List queryList = query.list();
	            if (queryList != null && queryList.isEmpty()) {
	                return null;
	            } else {
	                System.out.println("list " + queryList);
	                return (List<Customers>) queryList;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            session.close();
	        }
	}
	 
	 public Customers findCustomerById(int id) {
	        Session session = null;
	        try {
	            session = HibernateUtil.getSession();
	            Query query = session.createQuery("from Customers c where c.cusId = :id");
	            query.setParameter("id", id);
	 
	            List queryList = query.list();
	            if (queryList != null && queryList.isEmpty()) {
	                return null;
	            } else {
	                return (Customers) queryList.get(0);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            session.close();
	        }
	    }
	 
	    public void updateCustomer(Customers customer) {
	        Session session = null;
	        try {
	            session = HibernateUtil.getSession();
	            session.saveOrUpdate(customer);
	            session.flush();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	    }
	 
	    public Customers addCustomer(Customers customer) {
	        Session session = null;
	        Transaction transaction = null;
	        try {
	            session = HibernateUtil.getSession();
	            System.out.println("session : "+session);
	            transaction = session.beginTransaction();
	            session.save(customer);
	            transaction.commit();
	            return customer;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	 
	    public void deleteCustomer(int id) {
	        Session session = null;
	        try {
	            session = HibernateUtil.getSession();
	            Transaction beginTransaction = session.beginTransaction();
	            Query createQuery = session.createQuery("delete from Customer c where c.cusId =:id");
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
