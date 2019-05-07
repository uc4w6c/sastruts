package org.seasar.sastruts.example.form;

public class TransferForm {

	private String accountId;
	private String name;
	private long transferAmount;

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getAccountId() {
		return accountId;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void setTransferAmount(long transferAmount) {
		this.transferAmount = transferAmount;
	}
	public long getTransferAmount() {
		return transferAmount;
	}

}
