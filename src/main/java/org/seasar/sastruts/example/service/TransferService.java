package org.seasar.sastruts.example.service;

import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.sastruts.example.dao.BalanceDao;
import org.seasar.sastruts.example.dao.TransferDao;

public class TransferService {

	@Binding
	BalanceDao balanceDao;

	@Binding
	TransferDao transferDao;


}
