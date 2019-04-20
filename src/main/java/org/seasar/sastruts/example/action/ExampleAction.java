package org.seasar.sastruts.example.action;

import javax.annotation.Resource;

import org.seasar.sastruts.example.dto.ExampleDto;
import org.seasar.sastruts.example.form.ExampleForm;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class ExampleAction {

	/** アクションフォーム */
	@Resource
	@ActionForm
	protected ExampleForm exampleForm;

	//public ExampleDto exampleDto;

	/** 入力画面の実行メソッド */
	@Execute(validator=false)
	public String index() {
		return "input.jsp";
	}

	/** エコー画面の実行メソッド */
	@Execute(input="input.jsp")
	public String echo() {
		//exampleDto.setFirstName(exampleForm.getFirstName());
		//exampleDto.setLastName(exampleForm.getLastName());
		//System.out.println("FirstName:::" + exampleForm.getName().getFirstName());
		//System.out.println("LastName:::" + exampleForm.getName().getLastName());
		return "echo.jsp";
	}
}
