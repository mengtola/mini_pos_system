package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.xml.HibernateUtil;
import com.domain.Users;

@Repository
public class UserDao {
    
	 public List<Users> list() {
	        Session session = null;
	        try {
	            session = HibernateUtil.getSession();
	            Query query = session.createQuery("from Users s");
	 
	            List queryList = query.list();
	            if (queryList != null && queryList.isEmpty()) {
	                return null;
	            } else {
	                System.out.println("list " + queryList);
	                return (List<Users>) queryList;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            session.close();
	        }
	}
	 
	 public Users getUserByAuthentication(String username, String password){ 
		 
		 Session session = null;
	        try {
	            session = HibernateUtil.getSession();
	            Query query = session.createQuery("from Users s where s.username = :username and s.password = :password");
	            query.setParameter("username", username);
	            query.setParameter("password", password);
	            
	            List queryList = query.list();
	            if (queryList != null && queryList.isEmpty()) {
	                return null;
	            } else {
	                return (Users) queryList.get(0);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            session.close();
	        }
		 
	 }
	 
	 public Users findUsersById(int id) {
	        Session session = null;
	        try {
	            session = HibernateUtil.getSession();
	            Query query = session.createQuery("from Users s where s.userId = :id");
	            query.setParameter("id", id);
	 
	            List queryList = query.list();
	            if (queryList != null && queryList.isEmpty()) {
	                return null;
	            } else {
	                return (Users) queryList.get(0);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        } finally {
	            session.close();
	        }
	    }
	 
	    public void updateUsers(Users Users) {
	        Session session = null;
	        try {
	            session = HibernateUtil.getSession();
	            session.saveOrUpdate(Users);
	            session.flush();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            session.close();
	        }
	    }
	 
	    public Users addUsers(Users Users) {
	        Session session = null;
	        Transaction transaction = null;
	        try {
	            session = HibernateUtil.getSession();
	            System.out.println("session : "+session);
	            transaction = session.beginTransaction();
	            session.save(Users);
	            transaction.commit();
	            return Users;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	 
	    public void deleteUsers(int id) {
	        Session session = null;
	        try {
	            session = HibernateUtil.getSession();
	            Transaction beginTransaction = session.beginTransaction();
	            Query createQuery = session.createQuery("delete from Users s where s.userId =:id");
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
