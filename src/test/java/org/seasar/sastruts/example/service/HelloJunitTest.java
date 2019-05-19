package org.seasar.sastruts.example.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.core.IsAnything;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class HelloJunitTest {

	HelloJunit helloJunit;
	private static final String FILE_PATH = "src/test/java/org/seasar/sastruts/example/service/JunitTest.txt";
	File file;
	FileReader filereader;

	@Before
	public void setUp() {
		helloJunit = new HelloJunit();
		File file = new File(FILE_PATH);
		try {
			filereader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Ignore
	@Test
	public void Helloと言う() {
		helloJunit = new HelloJunit();
		assertThat(helloJunit.sayHello(), is("Hello"));
	}

	@Test
	public void isを試す() {
		assertThat("Hello", is("Hello"));
		assertThat(1, is(1));
	}

	@Test
	public void notを試す() {
		assertThat("Hello", not("bye"));
		assertThat("Hello", is(not("bye")));
	}

	@Test
	public void nullValueを試す() {
		assertThat(null, nullValue());
	}

	@Test
	public void instanceOfを試す() {
		assertThat("Hello", instanceOf(String.class));
	}

	@Test
	public void sameInstanceを試す() {
		assertThat("Hello", sameInstance("Hello"));
	}

	@Test
	public void allOfを試す() {
		assertThat("Hello", allOf(not("bye"), sameInstance("Hello")));
	}

	@Test(expected = IllegalArgumentException.class)
	public void ExceptionをTestアノテーションで検査() {
		helloJunit.throwException();
	}

	@Test
	public void Exceptionをcatchで検査() {
		try {
			helloJunit.throwException();
		} catch (IllegalArgumentException expected) {
			assertThat(expected.getMessage(), is("引数が不正です"));
		}
	}

	@Ignore
	@Test
	public void ファイル読み込みだけ() {
		int ch;
		try {
			while((ch = filereader.read()) != -1){
				System.out.print((char)ch);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@After
	public void termDown() {
		try {
			filereader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
