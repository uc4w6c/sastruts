package org.seasar.sastruts.example.dao;

import java.util.List;

import org.seasar.dao.annotation.tiger.S2Dao;
import org.seasar.sastruts.example.entity.Balance;

public interface GreetDao {
	public String getGreet();
	public String findGreet(int type);
	public void insertGreet(String greet);
}
