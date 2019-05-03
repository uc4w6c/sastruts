package org.seasar.sastruts.example.form.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonForm {

	private String firstName;
	private String lastName;

	public PersonForm(@JsonProperty("FirstName") String firstName,
					  @JsonProperty("LastName") String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

}
