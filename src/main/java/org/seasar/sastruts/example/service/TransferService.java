package org.seasar.sastruts.example.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.sastruts.example.dao.BalanceDao;
import org.seasar.sastruts.example.dao.TransferDao;
import org.seasar.sastruts.example.dto.TransferResultDto;
import org.seasar.sastruts.example.entity.Balance;
import org.seasar.sastruts.example.entity.Transfer;
import org.seasar.sastruts.example.util.BusinessLogicException;

public class TransferService {

	@Binding
	BalanceDao balanceDao;

	@Binding
	TransferDao transferDao;

	public TransferResultDto transfer(String payerAccountId,
										String payeeAccount,
										String payerName,
										long transferAmount) {

		Balance payerBalance = balanceDao.findByAccountId(payerAccountId);
		if (payerBalance == null)
			throw new BusinessLogicException("残高が取得できません。");

		if (transferAmount > payerBalance.amount)
			throw new BusinessLogicException("残高が足りません。");

		Balance payeeBalance = balanceDao.findByAccountId(payerAccountId);
		if (payeeBalance == null)
			throw new BusinessLogicException("残高が足りません。");

		Transfer peyerTransaction = new Transfer();
		peyerTransaction.accountId = payerAccountId;
		peyerTransaction.name = "";
		peyerTransaction.transferAmount = -transferAmount;
		// peyerTransaction.transferDate = new LocalDate(); // 日付型を確認したい

		Transfer payeeTransaction = new Transfer();

		return null;
	}


}
