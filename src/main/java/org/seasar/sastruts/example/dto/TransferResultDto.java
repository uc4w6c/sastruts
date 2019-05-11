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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Payer Account ID:").append(payerAccountId).append(",");
		sb.append("Payee Account ID:").append(payeeAccount).append(",");
		sb.append("Payer Name:").append(payerName).append(",");
		sb.append("Payee Name:").append(payeeName).append(",");
		sb.append("Transfer Amount:").append(transferAmount).append(",");
		sb.append("Amount:").append(amount).append(",");

		return sb.toString();
	}
}
