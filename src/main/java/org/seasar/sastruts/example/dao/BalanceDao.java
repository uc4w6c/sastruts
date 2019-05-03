package org.seasar.sastruts.example.dao;

import java.util.List;

import org.seasar.dao.annotation.tiger.S2Dao;
import org.seasar.sastruts.example.entity.Balance;

@S2Dao(bean = Balance.class)
public interface BalanceDao {
	public List<Balance> findAll();
}
