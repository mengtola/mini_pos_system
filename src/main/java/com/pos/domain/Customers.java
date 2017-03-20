/***/
package com.pos.domain;

public class Customers implements java.io.Serializable {
    private int cusId;
    private String cusName;
    private String cusPhone;
    
    public Customers() {
        
    }
    public Customers(int cusId, String cusName, String cusPhone) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.cusPhone = cusPhone;
    }

    public int getCusId() {
        return cusId;
    }
 
    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }
 
    public void setCusName(String cusName) {
        this.cusName = cusName;
    }
    
    public String getCusPhone() {
    	return cusPhone;
    }
    
    public void setCusPhone(String cusPhone) {
    	this.cusPhone = cusPhone;
    }
}
