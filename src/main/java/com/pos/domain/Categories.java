/***/
package com.pos.domain;

import java.util.HashSet;
import java.util.Set;

public class Categories implements java.io.Serializable {
    private int catId;
    private String catName;
    private Set<Products> products;
    public Categories() {
        // TODO Auto-generated constructor stub
    }
    public int getCatId() {
        return catId;
    }
 
    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }
 
    public void setCatName(String catName) {
        this.catName = catName;
    }
    
    public Set<Products> getProducts(){
    	return products;
    }
    
    public void setProducts(Set<Products> products){
    	this.products = products;
    }
}
