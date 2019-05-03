package org.seasar.sastruts.example.service;

import java.io.IOException;

import org.seasar.sastruts.example.form.example.PersonForm;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ExampleService {

	public void printJson() {
		String people = "{\"FirstName\":\"太郎\",\"LastName\":\"田中\"}";
		System.out.println("people:::" + people);
		ObjectMapper mapper = new ObjectMapper();
		try {
			PersonForm peopleForm = mapper.readValue(people, PersonForm.class);
			System.out.println(peopleForm.getFirstName());
			System.out.println(peopleForm.getLastName());
		} catch (IOException e) {
			// エラーが出ても一旦何もしない。本来だめ
		}
	}
}
