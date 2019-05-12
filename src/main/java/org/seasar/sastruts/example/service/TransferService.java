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
										String payeeAccountId,
										String payerName,
										long transferAmount) {

		Balance payerBalance = balanceDao.findByAccountId(payerAccountId);
		if (payerBalance == null)
			throw new BusinessLogicException("残高が取得できません");

		if (transferAmount > payerBalance.amount)
			throw new BusinessLogicException("残高が足りません");

		Balance payeeBalance = balanceDao.findByAccountId(payeeAccountId);
		if (payeeBalance == null)
			throw new BusinessLogicException("振込先口座が存在しません");

		LocalDateTime transferDate = LocalDateTime.now();

		Transfer peyerTransaction = new Transfer();
		peyerTransaction.accountId = payerAccountId;
		peyerTransaction.name = payerBalance.name;
		peyerTransaction.transferAmount = -transferAmount;
		peyerTransaction.transferDate = transferDate;

		Transfer payeeTransaction = new Transfer();
		payeeTransaction.accountId = payeeAccountId;
		payeeTransaction.name = payeeBalance.name;
		payeeTransaction.transferAmount = transferAmount;
		payeeTransaction.transferDate = transferDate;

		transferDao.insertTransfer(peyerTransaction);
		transferDao.insertTransfer(payeeTransaction);
		balanceDao.updateAmount(payerAccountId, -transferAmount);
		balanceDao.updateAmount(payeeAccountId, transferAmount);

		Balance updatedPayerBalance = balanceDao.findByAccountId(payerAccountId);

		// payeeAccount は payeeAccountIDに変更すること
		return new TransferResultDto(payerAccountId, payeeAccountId,
									 payerBalance.name, payeeBalance.name,
									 transferAmount,
									 updatedPayerBalance.amount);
	}


}
