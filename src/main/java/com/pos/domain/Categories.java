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
@Table(name = "categories", catalog="mini_pos_system", uniqueConstraints = {@UniqueConstraint(columnNames="cat_id")})
public class Categories implements java.io.Serializable {
    private int catId;
    private String catName;
    private boolean catActive;
    private Set<Products> products = new HashSet<Products>(0);

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "cat_id", unique = true, nullable = false)
    public int getCatId() {
        return catId;
    }
 
    public void setCatId(int catId) {
        this.catId = catId;
    }

    @Column(name = "cat_name", nullable = false, length = 100)
    public String getCatName() {
        return catName;
    }
 
    public void setCatName(String catName) {
        this.catName = catName;
    }
    
    @Column(name = "cat_active")
    public boolean getCatActive(){
    	return catActive;
    }
    
    public void setCatActive(boolean catActive){
    	this.catActive = catActive;
    }
    
    @OneToMany(mappedBy = "category")
    public Set<Products> getProduct(){
    	return products;
    }
    
    public void setProduct(Set<Products> products){
    	this.products = products;
    }
}
