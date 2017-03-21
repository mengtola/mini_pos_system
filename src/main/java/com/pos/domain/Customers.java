/***/
package com.pos.domain;

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
@Table(name = "customers", catalog="mini_pos_system", uniqueConstraints = {@UniqueConstraint(columnNames="cus_id")})
public class Customers implements java.io.Serializable {
    private int cusId;
    private String cusName;
    private String cusPhone;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "cus_id", unique = true, nullable = false)
    public int getCusId() {
        return cusId;
    }
 
    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    @Column(name = "cus_name", nullable = false, length = 100)
    public String getCusName() {
        return cusName;
    }
 
    public void setCusName(String cusName) {
        this.cusName = cusName;
    }
    
    @Column(name = "cus_phone", nullable = false, length = 100)
    public String getCusPhone() {
    	return cusPhone;
    }
    
    public void setCusPhone(String cusPhone) {
    	this.cusPhone = cusPhone;
    }
}
