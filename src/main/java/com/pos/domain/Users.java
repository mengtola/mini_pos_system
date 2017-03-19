/***/
package com.pos.domain;

import java.util.Date;

public class Users implements java.io.Serializable {
    private int userId;
    private String name;
    private String username;
    private String password;
    private boolean active;
    private Date regDate;
    private Date lastLogin;
    
    public Users() {
        
    }
    public Users(int userId, String name,String username,String password, boolean active, Date regDate, Date lastLogin) {
        this.userId = userId;
        this.name  = name;
        this.username = username;
        this.password = password;
        this.active = active;
        this.regDate = regDate;
        this.lastLogin = lastLogin;
    }

    public int getUserId() {
        return userId;
    }
 
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
   
    public String getUsername(){
    	
    	return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword(){
    	
    	return password;
    }
    
    public void setPassword(String password){
    	
    	this.password = password;
    }
    
    public boolean getActive(){
    	return active;
    }
    
    public void setActive(boolean active){
    	
    	this.active = active;
    }
    
    public Date getregDate(){
    	
    	return regDate;
    }
    
    public void setregDate(Date regDate){
    	this.regDate = regDate;
    }
    
    public Date getlastLogin(){
    	
    	return lastLogin;
    }
    
    public void setlastLogin(Date lastLogin){
    	this.lastLogin = lastLogin;
    }
}
