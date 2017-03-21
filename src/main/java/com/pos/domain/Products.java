/***/
package com.pos.domain;

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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "products", catalog="mini_pos_system")
public class Products implements java.io.Serializable {
    private int proId;
    private String proName;
    private String proCode;
    private int qty;
    private int unitPrice;
    private boolean proStatus;
    private Categories category;
    private Brands brand;

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
    
    @Column(name = "unit_price")  
    public int getUnitPrice(){
    	return unitPrice;
    }
    
    public void setUnitPrice(int unitPrice){
    	this.unitPrice = unitPrice;
    }
    
    @Column(name = "pro_status")
    public boolean getProStatus(){
    	return proStatus;
    }
    
    public void setProStatus(boolean proStatus){
    	this.proStatus = proStatus;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cat_id", nullable= false)
    public Categories getCategory(){
    	return category;
    }
    
    public void setCategory(Categories category){
    	this.category = category;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bra_id", nullable= false)
    public Brands getBrand(){
    	return brand;
    }
    
    public void setBrand(Brands brand){
    	this.brand = brand;
    }
}

