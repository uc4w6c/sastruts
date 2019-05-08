package org.seasar.sastruts.example.dto;

public class TransferResultDto {

	private final String payerAccountId;
	private final String payeeAccount;
	private final String payerName;
	private final String payeeName;
	private final long transferAmount;
	private final long amount;

	public TransferResultDto(String payerAccountId,
							 String payeeAccount,
							 String payerName,
							 String payeeName,
							 long transferAmount,
							 long amount) {

		this.payerAccountId = payerAccountId;
		this.payeeAccount = payeeAccount;
		this.payerName = payerName;
		this.payeeName = payeeName;
		this.transferAmount = transferAmount;
		this.amount = amount;

	}

	public String getPayerAccountId() {
		return payerAccountId;
	}

	public String getPayeeAccountId() {
		return payeeAccount;
	}

	public String getPayerName() {
		return payerName;
	}

	public String getPayeeName() {
		return payeeName;
	}

	public long getTransferAmount() {
		return transferAmount;
	}

	public long getAmount() {
		return amount;
	}
}
