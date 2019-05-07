package org.seasar.sastruts.example.action;

import java.util.List;

import javax.annotation.Resource;

import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.sastruts.example.entity.Balance;
import org.seasar.sastruts.example.form.BalanceForm;
import org.seasar.sastruts.example.form.ExampleForm;
import org.seasar.sastruts.example.form.TransferForm;
import org.seasar.sastruts.example.service.BalanceService;
import org.seasar.sastruts.example.service.TransferService;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ResponseUtil;

public class TransferAction {

	@Resource
	@ActionForm
	protected TransferForm transferForm;

	@Binding
	TransferService transferService;

	@Execute(validator=false)
	public String index() {
		return null;
	}

}
