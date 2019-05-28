package com.aap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="user")
public class UserBean {
	
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
private int customer_id;

@NotNull(message ="{error.nameNull}")
@Size(min=3,message ="{error.nameLength}")
private String userName;


@NotNull(message ="{error.emailNull}")
@Email(message ="{error.emailValid}")
private String email;

@NotNull(message ="{error.phoneNull}")
@Size(min=10,max=10,message ="{error.phoneLength}")
private String phone;

@NotNull(message ="{error.passwordNull}")
@Size(min=3,message ="{error.passwordLength}")
private String password;

public String getEmail() {
	return email;
}


public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public int getCustomer_id() {
	return customer_id;
}

public void setCustomer_id(int customer_id) {
	this.customer_id = customer_id;
}

}
