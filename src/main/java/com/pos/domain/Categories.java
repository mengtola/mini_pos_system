/***/
package com.pos.domain;

import java.util.Set;

public class Categories implements java.io.Serializable {
    private int catId;
    private String catName;
    private Set<Products> product;

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
    
    public Set<Products> getProduct(){
    	return product;
    }
    
    public void setProduct(Set<Products> product){
    	this.product = product;
    }
}
