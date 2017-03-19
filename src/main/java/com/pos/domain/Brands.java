/***/
package com.pos.domain;

import java.util.Set;

public class Brands implements java.io.Serializable {
    private int braId;
    private String braName;
    private String braDescription;
    private Set<Products> product;
    
    public Brands() {
        
    }
    public Brands(int braId, String braName, String braDescription) {
        this.braId = braId;
        this.braName = braName;
        this.braDescription = braDescription;
    }

    public int getBraId() {
        return braId;
    }
 
    public void setBraId(int braId) {
        this.braId = braId;
    }

    public String getBraName() {
        return braName;
    }
 
    public void setBraName(String braName) {
        this.braName = braName;
    }
    
    public Set<Products> getProduct(){
    	return product;
    }
    
    public void setProduct(Set<Products> product) {
    	this.product = product;
    }
    
}
