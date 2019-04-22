package org.seasar.sastruts.example.action;

import java.util.List;

import javax.annotation.Resource;

import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.sastruts.example.form.EchoForm;
import org.seasar.sastruts.example.service.EchoUsersService;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

public class EchoAction {

	/** アクションフォーム */
	@Resource
	@ActionForm
	protected EchoForm echoForm;

	@Binding
	EchoUsersService echoUsersService;

	// 表示用のpublicプロパティ
	public List<String> users;

	/** 入力画面の実行メソッド */
	@Execute(validator=false)
	public String index() {
		return "input.jsp";
	}

	/** エコー画面の実行メソッド */
	@Execute(validate="validate", input="input.jsp")
	public String echo() {
		return "echo.jsp";
	}

	@Execute(validator=false)
	public String users() {
		users = echoUsersService.findUsers();
		return "users.jsp";
	}

}
