package org.seasar.sastruts.example.form;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.framework.util.StringUtil;

public class TransferForm {

	private String payerAccountId;
	private String payeeAccountId;
	private String payerName;
	private long transferAmount;

	public void setPayerAccountId(String payerAccountId) {
		this.payerAccountId = payerAccountId;
	}
	public String getPayerAccountId() {
		return payerAccountId;
	}

	public void setPayeeAccountId(String payeeAccountId) {
		this.payeeAccountId = payeeAccountId;
	}
	public String getPayeeAccountId() {
		return payeeAccountId;
	}

	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}
	public String getPayerName() {
		return payerName;
	}

	public void setTransferAmount(long transferAmount) {
		this.transferAmount = transferAmount;
	}
	public long getTransferAmount() {
		return transferAmount;
	}

	public ActionMessages validate() {
		ActionMessages errors = new ActionMessages();

		// アノテーションでチェックできないか確認
		if(StringUtil.isEmpty(payerAccountId)) {
			errors.add("payerAccountId", new ActionMessage("振込口座番号が入力されていません。", false));
		}
		if(StringUtil.isEmpty(payeeAccountId)) {
			errors.add("payeeAccount", new ActionMessage("振込先口座番号が入力されていません。", false));
		}
		if(StringUtil.isEmpty(payerName)) {
			errors.add("payerName", new ActionMessage("振込人名が入力されていません。", false));
		}
		if(transferAmount <= 0) {
			errors.add("transferAmount", new ActionMessage("振込金額が不正です。", false));
		}

		return errors;
	}
}
