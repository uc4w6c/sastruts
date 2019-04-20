package org.seasar.sastruts.example.form;

import org.seasar.sastruts.example.dto.ExampleDto;

public class ExampleForm {

	private String name;
	private ExampleDto exampleDto;
	private String firstName;
	private String lastName;

	public void setName(String name) {
		System.out.println("setName start");
		this.name = name;
		String names[] = name.split(" ");

		//exampleDto.setFirstName(names[0]);
		//exampleDto.setLastName(names[1]);
		//this.firstName = names[0];
		//this.lastName = names[1];
	}
	public String getName() {
		return name;
	}
	/**
	public ExampleDto getName() {
		return exampleDto;
	}
	*/
	/**
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	*/
}
