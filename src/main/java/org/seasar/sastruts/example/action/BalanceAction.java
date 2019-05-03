package org.seasar.sastruts.example.action;

import java.util.List;

import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.sastruts.example.entity.Balance;
import org.seasar.sastruts.example.service.BalanceService;
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
			responseText.append(balance.toString() + "\r\n");
		}
		ResponseUtil.write(responseText.toString(), "text/html", "UTF-8");
		return null;
	}
}
