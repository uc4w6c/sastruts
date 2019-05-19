package org.seasar.sastruts.example.service;

public class HelloJunit {

	public String sayHello() {
		return "Hello";
	}

	public void throwException() {
		throw new IllegalArgumentException("引数が不正です");
	}
}
