package org.seasar.sastruts.example.service;

import static org.easymock.EasyMock.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.seasar.framework.unit.annotation.EasyMock;
import org.seasar.sastruts.example.dao.GreetDao;

public class HelloJunitTest {

	HelloJunit helloJunit;

	@EasyMock
	GreetDao greetDao;

	@Before
	public void setUp() {
		greetDao = createMock(GreetDao.class);
		helloJunit = new HelloJunit(greetDao);
	}

	@Test
	public void 挨拶を言う() {
		// setup（事前準備）
		expect(greetDao.getGreet()).andReturn("Hello");
		replay(greetDao);

		// exercise（実行）
		String actual = helloJunit.sayGreeting();

		// verify（検証）
		String expected = "Hello";
		assertThat(actual, is(expected));
		verify(greetDao);

		// tear down（後処理）
		// 何かあれば・・・
	}
}
