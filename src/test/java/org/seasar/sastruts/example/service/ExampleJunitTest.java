package org.seasar.sastruts.example.service;

import org.junit.Test;

public class ExampleJunitTest {

	ExampleJunit exampleJunit = new ExampleJunit();

	@Test
	public void 普通にテストしてみる() throws Exception {
		System.out.println(exampleJunit.sayGreeting());
	}


}
