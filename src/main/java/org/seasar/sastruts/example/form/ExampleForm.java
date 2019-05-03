package org.seasar.sastruts.example.form;

import java.io.IOException;

import org.seasar.sastruts.example.dto.ExampleDto;
import org.seasar.sastruts.example.form.example.PersonForm;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ExampleForm {

	private PersonForm personForm;
	//private String name;

	/*
	 * Seasarではjsonをそのままオブジェクトにセットすることは出来ない
	public void setPerson(PersonForm personForm) {
		this.personForm = personForm;
	}
	public PersonForm getPerson() {
		return this.personForm;
	}
	*/

	/*
	public void setPerson(String person) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			personForm = mapper.readValue(person, PersonForm.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public PersonForm getPerson() {
		return this.personForm;
	}
	*/

	public void setPerson(String person) {
		System.out.println("person:::" + person);
		ObjectMapper mapper = new ObjectMapper();
		try {
			personForm = mapper.readValue(person, PersonForm.class);
		} catch (IOException e) {
			// エラーが出ても一旦何もしない。本来だめ
		}
	}

	public PersonForm getPersonForm() {
		return this.personForm;
	}

}
