package org.seasar.sastruts.example.service;

import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.sastruts.example.dao.BalanceDao;
import org.seasar.sastruts.example.dao.GreetDao;

public class ExampleJunit extends AbstractJunit {
	protected String getMessage() {
		int term = 1;
		switch(term) {
		case 1:
			return "パスタ";
		case 2:
			return "ラーメン";
		default:
			return "ご飯";
		}
	}
}
