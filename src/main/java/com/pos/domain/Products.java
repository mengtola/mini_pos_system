/***/
package com.pos.domain;

public class Products implements java.io.Serializable {
    private int proId;
    private String proName;
    private String proCode;
    private int qty;
    private int unitPrice;
    private boolean proStatus;
    private Categories category;
    private Brands brand;
    
    public Products() {
        
    }
    public Products(int proId, String proName, String proCode,int qty,int unitPrice,boolean proStatus) {
        this.proId = proId;
        this.proName = proName;
        this.proCode = proCode;
        this.qty = qty;
        this.unitPrice = unitPrice;
        this.proStatus = proStatus;
    }

    public int getProId() {
        return proId;
    }
 
    public void setProId(int proId) {
        this.proId = proId;
    }
    
    
    public String getProName(){
    	return proName;
    }
    
    public void setProName(String proName){
    	this.proName = proName;
    }
    
    public String getProCode(){
    	return proCode;
    }
    
    public void setProCode(String proCode){
    	this.proCode = proCode;
    }

    public int getQty(){
    	return qty;
    }
    
    public void setQty(int qty){
    	this.qty = qty;
    }
    
    public int getUnitPrice(){
    	return unitPrice;
    }
    
    public void setUnitPrice(int unitPrice){
    	this.unitPrice = unitPrice;
    }
    
    public boolean getProStatus(){
    	return proStatus;
    }
    
    public void setProStatus(boolean proStatus){
    	this.proStatus = proStatus;
    }
    
    public Categories getCategory(){
    	return category;
    }
    
    public void setCategory(Categories category){
    	this.category = category;
    }
    
    public Brands getBrand(){
    	return brand;
    }
    
    public void setBrand(Brands brand){
    	this.brand = brand;
    }
}

