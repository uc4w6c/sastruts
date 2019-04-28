package org.seasar.sastruts.example.form;

import org.seasar.sastruts.example.dto.ExampleDto;
import org.seasar.sastruts.example.form.example.PeopleForm;

public class ExampleForm {

	private PeopleForm peopleForm;
	private String name;
	//private ExampleDto exampleDto;
	private String firstName;
	private String lastName;

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
		ObjectMapper mapper = new ObjectMapper();
		Hoge hoge = mapper.readValue(json, Hoge.class);
	}

	public PeopleForm getPeople() {
		return this.peopleForm;
	}

	public PeopleForm getPeopleForm() {
		return this.peopleForm;
	}

	public void setName(String name) {
		System.out.println("setName start");
		StackTraceElement[] ste = new Throwable().getStackTrace();
		for (int i = 0; i < ste.length; i++) {
		    System.out.println(ste[i].getClassName()); // クラス名を取得
		    System.out.println(ste[i].getMethodName()); // メソッド名を取得
		    System.out.println(ste[i].getFileName()); // ファイル名を取得
		    System.out.println(ste[i].getLineNumber()); // 行番号を取得（nativeメソッドの場合は取得できない）
		    System.out.println(ste[i].isNativeMethod()); // nativeメソッドか判定する。
		    System.out.println(ste[i]); // スタックトレースの情報を整形して表示
		}
		/*
		this.name = name;
		*/
		
		String names[] = name.split(" ");

		//ExampleDto exampleDto = new ExampleDto();
		//exampleDto.setFirstName(names[0]);
		//exampleDto.setLastName(names[1]);
		this.firstName = names[0];
		this.lastName = names[1];
	}
	/*
	public String getName() {
		return name;
	}
	*/

	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
}
