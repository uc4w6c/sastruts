package org.seasar.sastruts.example.form;

import org.seasar.sastruts.example.dto.ExampleDto;

public class ExampleForm {

	private String name;
	private ExampleDto exampleDto;
	private String firstName;
	private String lastName;

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
