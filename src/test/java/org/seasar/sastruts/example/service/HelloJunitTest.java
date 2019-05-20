package org.seasar.sastruts.example.service;

import static org.easymock.EasyMock.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
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

	@Ignore
	@Test
	public void 挨拶を言う() throws Exception {
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

	@Test
	public void 引数テスト() throws Exception {
		// setup（事前準備）
		expect(greetDao.findGreet(1)).andReturn("Hello");
		replay(greetDao);

		// exercise（実行）
		String actual = helloJunit.sayGreeting();

		// verify（検証）
		String expected = "パスタ";
		assertThat(actual, is(expected));
		verify(greetDao);
	}

	@Test
	public void voidメソッドをテスト() throws Exception {
		// setup（事前準備）
		greetDao.insertGreet("Good Night");
		expectLastCall();
		replay(greetDao);

		// exercise（実行）
		String actual = helloJunit.addGreet();

		// verify（検証）
		verify(greetDao);
	}

}
