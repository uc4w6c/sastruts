package org.seasar.sastruts.example.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.unit.Seasar2;
import org.seasar.framework.unit.annotation.EasyMock;
import org.seasar.framework.unit.annotation.EasyMockType;
import org.seasar.sastruts.example.dao.BalanceDao;
import org.seasar.sastruts.example.dao.TransferDao;
import org.seasar.sastruts.example.dto.TransferResultDto;
import org.seasar.sastruts.example.entity.Balance;
import org.seasar.sastruts.example.entity.Transfer;
import org.seasar.sastruts.example.util.BusinessLogicException;

import static org.easymock.EasyMock.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(Seasar2.class)
public class TransferServiceTest {

	@Binding
	TransferService transferService;

	@EasyMock(value = EasyMockType.DEFAULT, register = true)
	BalanceDao balanceDao;

	@EasyMock(value = EasyMockType.DEFAULT, register = true)
	TransferDao transferDao;

	private static final Balance ACCOUNT1_BEFORE_BALANCE;
	private static final Balance ACCOUNT2_BALANCE;
	private static final Balance ACCOUNT1_AFTER_BALANCE;
	static {
		ACCOUNT1_BEFORE_BALANCE = new Balance();
		ACCOUNT1_BEFORE_BALANCE.accountId = "1";
		ACCOUNT1_BEFORE_BALANCE.name = "田中太郎";
		ACCOUNT1_BEFORE_BALANCE.amount = 10000;

		ACCOUNT1_AFTER_BALANCE = new Balance();
		ACCOUNT1_AFTER_BALANCE.accountId = "1";
		ACCOUNT1_AFTER_BALANCE.name = "田中太郎";
		ACCOUNT1_AFTER_BALANCE.amount = 9000;

		ACCOUNT2_BALANCE = new Balance();
		ACCOUNT2_BALANCE.accountId = "2";
		ACCOUNT2_BALANCE.name = "佐藤花子";
		ACCOUNT2_BALANCE.amount = 20000;
	}

	public void record残高が取得できない() throws Exception {
		expect(balanceDao.findByAccountId("1")).andReturn(null);
	}

	@Test
	public void 残高が取得できない() {
		try {
			transferService.transfer("1", "2", "田中太郎", 100);
		} catch (BusinessLogicException expected) {
			assertThat(expected.getMessage(), is("残高が取得できません"));
		}
	}

	public void record残高が足りない() throws Exception {
		expect(balanceDao.findByAccountId("1")).andReturn(ACCOUNT1_BEFORE_BALANCE);
	}

	@Test
	public void 残高が足りない() {
		try {
			transferService.transfer("1", "2", "田中太郎", 10001);
		} catch (BusinessLogicException expected) {
			assertThat(expected.getMessage(), is("残高が足りません"));
		}
	}

	public void record振込先口座が存在しない() throws Exception {
		expect(balanceDao.findByAccountId("1")).andReturn(ACCOUNT1_BEFORE_BALANCE);
		expect(balanceDao.findByAccountId("2")).andReturn(null);
	}

	@Test
	public void 振込先口座が存在しない() {
		try {
			transferService.transfer("1", "2", "田中太郎", 9999);
		} catch (BusinessLogicException expected) {
			assertThat(expected.getMessage(), is("振込先口座が存在しません"));
		}
	}

	public void record正常テスト() throws Exception {
		expect(balanceDao.findByAccountId("1")).andReturn(ACCOUNT1_BEFORE_BALANCE).andReturn(ACCOUNT1_AFTER_BALANCE);
		expect(balanceDao.findByAccountId("2")).andReturn(ACCOUNT2_BALANCE);
		transferDao.insertTransfer(isA(Transfer.class));
		expectLastCall().times(2);
		expect(balanceDao.updateAmount("1", -1000)).andReturn(1);
		expect(balanceDao.updateAmount("2", 1000)).andReturn(1);
	}

	@Test
	public void 正常テスト() {
		TransferResultDto expectTransferResult = 
					new TransferResultDto("1", "2",
										  ACCOUNT1_BEFORE_BALANCE.name, ACCOUNT2_BALANCE.name,
										  1000, ACCOUNT1_AFTER_BALANCE.amount);

		TransferResultDto transferResultDto = transferService.transfer("1", "2", "田中太郎", 1000);
		assertThat(transferResultDto.toString(), is(expectTransferResult.toString()));
	}
}
