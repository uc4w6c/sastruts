package org.seasar.sastruts.example.action;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Map;

import javax.annotation.Resource;

import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.util.tiger.GenericUtil;
import org.seasar.sastruts.example.dto.ExampleDto;
import org.seasar.sastruts.example.form.ExampleForm;
import org.seasar.sastruts.example.form.example.PeopleForm;
import org.seasar.sastruts.example.service.ExampleService;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ExampleAction {

	/** アクションフォーム */
	@Resource
	@ActionForm
	protected ExampleForm exampleForm;

	//public ExampleDto exampleDto;

	@Binding
	ExampleService exampleService;

	/** 入力画面の実行メソッド */
	@Execute(validator=false)
	public String index() {
		//ExampleService exampleService = new ExampleService();
		exampleService.printJson();
		/*
		Method[] methods = ExampleForm.class.getMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}
		*/
		return "input.jsp";
	}

	/** エコー画面の実行メソッド */
	@Execute(input="input.jsp")
	public String echo() {
		System.out.println(exampleForm.getPeopleForm().getFirstName());
		System.out.println(exampleForm.getPeopleForm().getLastName());
		//exampleDto.setFirstName(exampleForm.getFirstName());
		//exampleDto.setLastName(exampleForm.getLastName());
		//System.out.println("FirstName:::" + exampleForm.getName().getFirstName());
		//System.out.println("LastName:::" + exampleForm.getName().getLastName());
		return "echo.jsp";
	}
}
