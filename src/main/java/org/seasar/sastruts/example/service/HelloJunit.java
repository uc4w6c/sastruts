package org.seasar.sastruts.example.service;

import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.sastruts.example.dao.BalanceDao;
import org.seasar.sastruts.example.dao.GreetDao;

public class HelloJunit {

	GreetDao greetDao;
	
	public HelloJunit(GreetDao greetDao) {
		this.greetDao = greetDao;
	}

	public String sayGreeting() {
		//greetDao.getGreet();
		String greet = greetDao.findGreet(1);
		if (greet.contentEquals("Hello")) {
			return "パスタ";
		} else {
			return "ラーメン";
		}
	}

	public String addGreet() {
		greetDao.insertGreet("Good Night");
		return "OK";
	}

	public String sayHello() {
		return "Hello";
	}

	public void throwException() {
		throw new IllegalArgumentException("引数が不正です");
	}
}
