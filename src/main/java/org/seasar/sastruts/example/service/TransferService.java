package org.seasar.sastruts.example.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.sastruts.example.dao.BalanceDao;
import org.seasar.sastruts.example.dao.TransferDao;
import org.seasar.sastruts.example.dto.TransferResultDto;
import org.seasar.sastruts.example.entity.Balance;
import org.seasar.sastruts.example.entity.Transfer;

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
			// Exceptionをいれること。暫定でreturn をしているだけ
			return null;

		if (transferAmount > payerBalance.amount)
			// Exceptionを入れること。暫定return
			return null;

		Balance payeeBalance = balanceDao.findByAccountId(payerAccountId);
		if (payeeBalance == null)
			// Exceptionを入れること。暫定return
			return null;

		Transfer peyerTransaction = new Transfer();
		peyerTransaction.accountId = payerAccountId;
		peyerTransaction.name = "";
		peyerTransaction.transferAmount = -transferAmount;
		// peyerTransaction.transferDate = new LocalDate(); // 日付型を確認したい

		Transfer payeeTransaction = new Transfer();

		return null;
	}


}
