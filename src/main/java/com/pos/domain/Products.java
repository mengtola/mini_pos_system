/***/
package com.pos.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "products", catalog="mini_pos_system")
public class Products implements java.io.Serializable {
    private int proId;
    private int catId;
    private int braId;
    private String proName;
    private String proCode;
    private int qty;
    private int stockPrice;
    private int salePrice;
    private boolean proStatus;
    private boolean proActive;
    private Categories category;
    private Brands brand;
    private Set<Sales> sales = new HashSet<Sales>(0);

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "pro_id", unique = true, nullable = false)
    public int getProId() {
        return proId;
    }
 
    public void setProId(int proId) {
        this.proId = proId;
    }
    
    @Column(name = "pro_name", nullable = false, length = 100)
    public String getProName(){
    	return proName;
    }
    
    public void setProName(String proName){
    	this.proName = proName;
    }
    
    @Column(name = "pro_code", nullable = false, length = 100)  
    public String getProCode(){
    	return proCode;
    }
    
    public void setProCode(String proCode){
    	this.proCode = proCode;
    }

    @Column(name = "qty")
    public int getQty(){
    	return qty;
    }
    
    public void setQty(int qty){
    	this.qty = qty;
    }
    
    @Column(name = "stock_price")  
    public int getStockPrice(){
    	return stockPrice;
    }
    
    public void setStockPrice(int stockPrice){
    	this.stockPrice = stockPrice;
    }
    
    @Column(name = "sale_price")  
    public int getSalePrice(){
    	return salePrice;
    }
    
    public void setSalePrice(int salePrice){
    	this.salePrice = salePrice;
    }
    
    @Column(name = "pro_status")
    public boolean getProStatus(){
    	return proStatus;
    }
    
    public void setProStatus(boolean proStatus){
    	this.proStatus = proStatus;
    }
    
    @ManyToOne()
    @JoinColumn(name = "cat_id", nullable= false)
    public Categories getCategory(){
    	return category;
    }
    
    public void setCategory(Categories category){
    	this.category = category;
    }
    
    @ManyToOne()
    @JoinColumn(name = "bra_id", nullable= false)
    public Brands getBrand(){
    	return brand;
    }
    
    public void setBrand(Brands brand){
    	this.brand = brand;
    }
    
    @OneToMany(mappedBy = "product")
    public Set<Sales> getSale(){
    	return sales;
    }
    
    public void setSale(Set<Sales> sales){
    	this.sales = sales;
    }

    @Column(name = "pro_active")
	public boolean getProActive() {
		return proActive;
	}

	public void setProActive(boolean proActive) {
		this.proActive = proActive;
	}

	@Column(name = "cat_id", insertable = false, updatable = false)
	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	@Column(name = "bra_id", insertable = false, updatable = false)
	public int getBraId() {
		return braId;
	}

	public void setBraId(int braId) {
		this.braId = braId;
	}
}

