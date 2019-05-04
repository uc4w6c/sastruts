package org.seasar.sastruts.example.service;

import java.util.Collections;
import java.util.List;

import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.sastruts.example.dao.BalanceDao;
import org.seasar.sastruts.example.entity.Balance;

public class BalanceService {

	@Binding
	BalanceDao balanceDao;

	public List<Balance> findAll() {
		return balanceDao.findAll();
	}

	public List<Balance> findByName(String name) {
		/*
		StringBuilder sql = new StringBuilder();
		sql.append("name = '").append(name).append("'");
		return balanceDao.findByName(sql.toString());
		*/
		return balanceDao.findByName(name);
	}
}
