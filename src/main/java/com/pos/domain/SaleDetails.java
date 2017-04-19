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
@Table(name = "saledetails", catalog="mini_pos_system")
public class SaleDetails implements java.io.Serializable {
	
	private int detailId;
    private int saleId;
    private int proId;
    private int salePrice;
    private int saleQty;
    private Products product;
    private Sales sale;
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "detail_id", unique = true, nullable = false)
    public int getDetailId(){
    	return detailId; 
    }
    
    public void setDetailId(int detailId){
    	this.detailId = detailId;
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
    
    @ManyToOne()
    @JoinColumn(name = "pro_id", nullable= false)
    public Products getProduct(){
    	return product;
    }
    
    public void setProduct(Products product){
    	this.product = product;
    }

    @Column(name = "pro_id", insertable = false, updatable = false)
	public int getProId() {
		return proId;
	}

	public void setProId(int proId) {
		this.proId = proId;
	}
	
	@ManyToOne()
	@JoinColumn(name = "sale_id", nullable= false)
	public Sales getSale() {
		return sale;
	}

	public void setSale(Sales sale) {
		this.sale = sale;
	}

	@Column(name = "sale_id", insertable = false, updatable = false)
	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

    
}

