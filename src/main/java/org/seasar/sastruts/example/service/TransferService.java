package org.seasar.sastruts.example.service;

import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.sastruts.example.dao.BalanceDao;
import org.seasar.sastruts.example.dao.TransferDao;
import org.seasar.sastruts.example.dto.TransferResultDto;
import org.seasar.sastruts.example.entity.Balance;

public class TransferService {

	@Binding
	BalanceDao balanceDao;

	@Binding
	TransferDao transferDao;

	public TransferResultDto transfer(String payerAccountId,
										String payeeAccount,
										String payerName,
										long transferAmount) {

		Balance balance = balanceDao.findByAccountId(payerAccountId);


		return null;
	}


}
