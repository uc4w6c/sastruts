package org.seasar.sastruts.example.action;

import org.seasar.struts.annotation.Execute;

public class SampleAction {

	// 表示用のpublicプロパティ
	public String message;

	@Execute(validator=false)
	public String index() {
		this.message = "Hello World!";
		return "index.jsp";
	}
}
