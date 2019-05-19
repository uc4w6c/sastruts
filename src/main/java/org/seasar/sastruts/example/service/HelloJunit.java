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
		return greetDao.getGreet();
	}

	public String sayHello() {
		return "Hello";
	}

	public void throwException() {
		throw new IllegalArgumentException("引数が不正です");
	}
}
