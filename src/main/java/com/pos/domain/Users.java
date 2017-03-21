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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "users", catalog="mini_pos_system", uniqueConstraints = {@UniqueConstraint(columnNames="user_id")})
public class Users implements java.io.Serializable {
    private int userId;
    private String name;
    private String username;
    private String password;
    private boolean active;
    private Date regDate;
    private Date lastLogin;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    public int getUserId() {
        return userId;
    }
 
    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    @Column(name = "username", nullable = false, length = 100)
    public String getUsername(){
    	
    	return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Column(name = "password", nullable = false, length = 100)
    public String getPassword(){
    	
    	return password;
    }
    
    public void setPassword(String password){
    	
    	this.password = password;
    }
    
    @Column(name = "active")
    public boolean getActive(){
    	return active;
    }
    
    public void setActive(boolean active){
    	
    	this.active = active;
    }
    
    @Temporal(TemporalType.DATE)
    @Column(name = "reg_date", nullable = false)
    public Date getRegDate(){
    	
    	return regDate;
    }
    
    public void setRegDate(Date regDate){
    	this.regDate = regDate;
    }
    
    @Temporal(TemporalType.DATE)
    @Column(name = "last_login", nullable = false)
    public Date getlastLogin(){
    	
    	return lastLogin;
    }
    
    public void setlastLogin(Date lastLogin){
    	this.lastLogin = lastLogin;
    }
}
