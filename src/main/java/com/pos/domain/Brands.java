/***/
package com.pos.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "brands", catalog="mini_pos_system", uniqueConstraints = {@UniqueConstraint(columnNames="bra_id")})
public class Brands implements java.io.Serializable {
    private int braId;
    private String braName;
    private boolean braActive;
    private Set<Products> products = new HashSet<Products>(0);

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "bra_id", unique = true, nullable = false)
    public int getBraId() {
        return braId;
    }
 
    public void setBraId(int braId) {
        this.braId = braId;
    }

    @Column(name = "bra_name", nullable = false, length = 100)
    public String getBraName() {
        return braName;
    }
 
    public void setBraName(String braName) {
        this.braName = braName;
    }
    
    @Column(name = "bra_active")
    public boolean getBraActive(){
    	return braActive;
    }
    
    public void setBraActive(boolean braActive){
    	this.braActive = braActive;
    }
    
    @OneToMany(mappedBy = "brand")
    public Set<Products> getProduct(){
    	return products;
    }
    
    public void setProduct(Set<Products> products) {
    	this.products = products;
    }
    
}
