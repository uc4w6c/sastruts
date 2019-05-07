package org.seasar.sastruts.example.dao;

import java.util.List;

import org.seasar.dao.annotation.tiger.S2Dao;
import org.seasar.sastruts.example.entity.Transfer;

@S2Dao(bean = Transfer.class)
public interface TransferDao {
	public void insertTransfer(Transfer transfer);
}
