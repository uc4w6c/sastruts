package org.seasar.sastruts.example.dao;

import java.util.List;

import org.seasar.dao.annotation.tiger.Arguments;
import org.seasar.dao.annotation.tiger.Query;
import org.seasar.dao.annotation.tiger.S2Dao;
import org.seasar.dao.annotation.tiger.Sql;
import org.seasar.sastruts.example.entity.Balance;

@S2Dao(bean = Balance.class)
public interface BalanceDao {
	public List<Balance> findAll();

	@Arguments({"name"})
	//@Sql("select id, name, amount, created_at, updated_at from balance where name = /*name*/'田中' ")
	@Query("name = /*name*/'田中'")
	public List<Balance> findByName(String name);
}
