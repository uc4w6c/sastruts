package org.seasar.sastruts.example.service;

public abstract class AbstractJunit {
	public String sayGreeting() {
		return this.getMessage();
	}
	abstract protected String getMessage();

}
