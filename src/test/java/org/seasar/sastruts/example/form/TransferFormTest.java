package org.seasar.sastruts.example.form;

import static org.easymock.EasyMock.expect;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.Iterator;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.junit.Before;
import org.junit.Test;
import org.seasar.sastruts.example.action.TransferAction;

/**
 * TransferFormテスト用クラス
 * @author ysaito
 *
 */
public class TransferFormTest {

	private TransferForm transferForm = new TransferForm();

	private static final TransferForm EXPECT_TRANSFER_FORM = new TransferForm();
	static {
		EXPECT_TRANSFER_FORM.setPayerAccountId("1");
		EXPECT_TRANSFER_FORM.setPayeeAccountId("2");
		EXPECT_TRANSFER_FORM.setPayerName("田中太郎");
		EXPECT_TRANSFER_FORM.setTransferAmount(1);
	}

	@Test
	public void 振込口座番号未入力() {
		transferForm.setPayerAccountId(null);
		transferForm.setPayeeAccountId(EXPECT_TRANSFER_FORM.getPayeeAccountId());
		transferForm.setPayerName(EXPECT_TRANSFER_FORM.getPayerName());
		transferForm.setTransferAmount(EXPECT_TRANSFER_FORM.getTransferAmount());
		ActionMessages actionMessages = transferForm.validate();

		String resultMessage = getMessage(actionMessages);

		assertThat(actionMessages.size(), is(1));
		assertThat(resultMessage, is("振込口座番号が入力されていません。"));
	}

	@Test
	public void 振込先口座番号未入力() {
		transferForm.setPayerAccountId(EXPECT_TRANSFER_FORM.getPayerAccountId());
		transferForm.setPayeeAccountId(null);
		transferForm.setPayerName(EXPECT_TRANSFER_FORM.getPayerName());
		transferForm.setTransferAmount(EXPECT_TRANSFER_FORM.getTransferAmount());
		ActionMessages actionMessages = transferForm.validate();

		String resultMessage = getMessage(actionMessages);

		assertThat(actionMessages.size(), is(1));
		assertThat(resultMessage, is("振込先口座番号が入力されていません。"));
	}

	@Test
	public void 振込人名未入力() {
		transferForm.setPayerAccountId(EXPECT_TRANSFER_FORM.getPayerAccountId());
		transferForm.setPayeeAccountId(EXPECT_TRANSFER_FORM.getPayeeAccountId());
		transferForm.setPayerName(null);
		transferForm.setTransferAmount(EXPECT_TRANSFER_FORM.getTransferAmount());
		ActionMessages actionMessages = transferForm.validate();

		String resultMessage = getMessage(actionMessages);

		assertThat(actionMessages.size(), is(1));
		assertThat(resultMessage, is("振込人名が入力されていません。"));
	}

	@Test
	public void 振込金額未入力() {
		transferForm.setPayerAccountId(EXPECT_TRANSFER_FORM.getPayerAccountId());
		transferForm.setPayeeAccountId(EXPECT_TRANSFER_FORM.getPayeeAccountId());
		transferForm.setPayerName(EXPECT_TRANSFER_FORM.getPayerName());
		// transferForm.setTransferAmount(EXPECT_TRANSFER_FORM.getTransferAmount());
		ActionMessages actionMessages = transferForm.validate();

		String resultMessage = getMessage(actionMessages);

		assertThat(actionMessages.size(), is(1));
		assertThat(resultMessage, is("振込金額が不正です。"));
	}

	@Test
	public void 振込金額マイナス() {
		transferForm.setPayerAccountId(EXPECT_TRANSFER_FORM.getPayerAccountId());
		transferForm.setPayeeAccountId(EXPECT_TRANSFER_FORM.getPayeeAccountId());
		transferForm.setPayerName(EXPECT_TRANSFER_FORM.getPayerName());
		transferForm.setTransferAmount(-1);
		ActionMessages actionMessages = transferForm.validate();

		String resultMessage = getMessage(actionMessages);

		assertThat(actionMessages.size(), is(1));
		assertThat(resultMessage, is("振込金額が不正です。"));
	}

	@Test
	public void エラーなし() {
		transferForm.setPayerAccountId(EXPECT_TRANSFER_FORM.getPayerAccountId());
		transferForm.setPayeeAccountId(EXPECT_TRANSFER_FORM.getPayeeAccountId());
		transferForm.setPayerName(EXPECT_TRANSFER_FORM.getPayerName());
		transferForm.setTransferAmount(EXPECT_TRANSFER_FORM.getTransferAmount());
		ActionMessages actionMessages = transferForm.validate();
		assertThat(actionMessages.size(), is(0));
	}

	private String getMessage(ActionMessages actionMessages) {
		String resultMessage = null;
		Iterator<ActionMessage> iterator = actionMessages.get();
		while (iterator.hasNext()) {
			ActionMessage actionMessage = ((ActionMessage) iterator.next());
			resultMessage = actionMessage.getKey();
		}
		return resultMessage;
	}

}
