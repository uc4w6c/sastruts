package org.seasar.sastruts.example.action;

import java.util.List;

import javax.annotation.Resource;

import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.sastruts.example.entity.Balance;
import org.seasar.sastruts.example.form.EchoForm;
import org.seasar.sastruts.example.service.BalanceService;
import org.seasar.sastruts.example.service.EchoUsersService;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ResponseUtil;

public class BalanceAction {

	@Binding
	BalanceService balanceService;

	@Execute(validator=false)
	public String index() {
		List<Balance> balanceList = balanceService.findAll();
		System.out.println("BALANCE_SIZE:" + balanceList.size());
		StringBuilder responseText = new StringBuilder();

		for (Balance balance : balanceList) {
			responseText.append(balance.toString());
		}
		ResponseUtil.write(responseText.toString(), "plain/text", "UTF-8");
		return null;
	}
}
