package com.spittr;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Spitter {
	private long _ID;
	
	@NotNull
	@Size(min=5, max=25 , message= "{firstName.size}")
	private String firstName;
	
	@NotNull
	@Size(min=5, max=25 , message= "{lastName.size}")
	private String lastName;
	
	@NotNull
	@Size(min=5,max=10 , message= "{password.size}")
	private String password;
	
	@NotNull
	@Size(min=5,max=15 , message= "{userName.size}")
	private String userName;
	
	public String getFirstName() {
		return firstName;
	}
	
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
