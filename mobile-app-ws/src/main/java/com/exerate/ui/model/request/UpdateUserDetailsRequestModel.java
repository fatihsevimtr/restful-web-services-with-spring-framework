package com.exerate.ui.model.request;

import org.hibernate.validator.constraints.Length;

public class UpdateUserDetailsRequestModel {

	@Length(min = 1,message = "First name can not be null")
	private String firstName;
	
	@Length(min = 1,message = "Last name can not be null")
	private String lastName;
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
}
