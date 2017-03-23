/***/
package com.pos.domain;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "sales", catalog="mini_pos_system")
public class Sales implements java.io.Serializable {
    private int saleId;
    private int proId;
    private int salePrice;
    private int saleQty;
    private Date saleDate;
    private int cusId;
    private int userId;
    private Date userEdit;
    private Products product;
    private Customers customer;
    private Users user;
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "sale_id", unique = true, nullable = false)
    public int getSaleId(){
    	return saleId; 
    }
    
    public void setSaleId(int saleId){
    	this.saleId = saleId;
    }
    
    @Column(name = "sale_price")
    public int getSalePrice() {
    	return salePrice;
    }
    
    public void setSalePrice(int salePrice){
    	
    	this.salePrice = salePrice;
    }
    
    @Column(name = "sale_qty")
    public int getSaleQty(){
    	return saleQty;
    }
    
    public void setSaleQty(int saleQty){
    	this.saleQty = saleQty;
    }
    
    @Temporal(TemporalType.DATE)
    @Column(name = "sale_date", nullable = false)
    public Date getSaleDate(){
    	return saleDate;
    }
    
    public void setSaleDate(Date saleDate){
    	this.saleDate = saleDate;
    }
    
    @Temporal(TemporalType.DATE)
    @Column(name = "user_edit", nullable = false)
    public Date getUserEdit(){
    	return userEdit;
    }
    
    public void setUserEdit(Date userEdit){
    	this.userEdit = userEdit;
    }
    
    @ManyToOne()
    @JoinColumn(name = "pro_id", nullable= false)
    public Products getProduct(){
    	return product;
    }
    
    public void setProduct(Products product){
    	this.product = product;
    }
    
    @ManyToOne()
    @JoinColumn(name = "cus_id", nullable= false)
    public Customers getCustomer(){
    	return customer;
    }
    
    public void setCustomer(Customers customer){
    	this.customer = customer;
    } 
    
    @ManyToOne()
    @JoinColumn(name = "user_id", nullable= false)
    public Users getUser(){
    	return user;
    }
    
    public void setUser(Users user){
    	this.user = user;
    }

    @Column(name = "pro_id", insertable = false, updatable = false)
	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}

	@Column(name = "cus_id", insertable = false, updatable = false)
	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	@Column(name = "user_id", insertable = false, updatable = false)
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

    
}

