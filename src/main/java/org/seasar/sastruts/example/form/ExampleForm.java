package org.seasar.sastruts.example.form;

import java.io.IOException;

import org.seasar.sastruts.example.dto.ExampleDto;
import org.seasar.sastruts.example.form.example.PeopleForm;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ExampleForm {

	private PeopleForm peopleForm;
	private String name;

	/*
	public ExampleDto getName() {
		return exampleDto;
	}
	*/

	/*
	public void setPeople(PeopleForm peopleForm) {
		this.peopleForm = peopleForm;
	}
	public PeopleForm getPeople() {
		return this.peopleForm;
	}
	*/
	public void setPeople(String people) {
		System.out.println("people:::" + people);
		ObjectMapper mapper = new ObjectMapper();
		try {
			peopleForm = mapper.readValue(people, PeopleForm.class);
		} catch (IOException e) {
			// エラーが出ても一旦何もしない。本来だめ
		}
	}

	public PeopleForm getPeopleForm() {
		return this.peopleForm;
	}

}
