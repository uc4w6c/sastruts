package org.seasar.sastruts.example.form.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PeopleForm {

	private String firstName;
	private String lastName;

	public PeopleForm(@JsonProperty("FirstName") String firstName,
					  @JsonProperty("LastName") String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

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
