package com.aap.bean;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Registration_Bean {
	
@NotNull(message ="{error.nameNull}")
@Size(min=3,message ="{error.nameLength}")
private String name;


@NotNull(message ="{error.emailNull}")
@Email(message ="{error.emailValid}")
private String email;

@NotNull(message ="{error.phoneNull}")
@Size(min=10,max=10,message ="{error.phoneLength}")
private String phone;

@NotNull(message ="{error.passwordNull}")
@Size(min=3,message ="{error.passwordLength}")
private String password;

/*@NotNull(message ="{error.cPasswordNull}")
@Size(min=3,message ="{error.cPasswordLength}")
private String confirmPassword;*/

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
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



}
