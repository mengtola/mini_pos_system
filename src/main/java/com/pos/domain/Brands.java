/***/
package com.pos.domain;

import java.util.HashSet;
import java.util.Set;

public class Brands implements java.io.Serializable {
    private int braId;
    private String braName;
    private String braDescription;
    private Set<Products> products ;
    
    public Brands() {
        
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
    
    /**
     * @return the braDescription
     */
    public String getBraDescription() {
        return braDescription;
    }
    /**
     * @param braDescription the braDescription to set
     */
    public void setBraDescription(String braDescription) {
        this.braDescription = braDescription;
    }
    public Set<Products> getProducts(){
        return products;
    }
    
    public void setProducts(Set<Products> products) {
        this.products = products;
    }
    
}
