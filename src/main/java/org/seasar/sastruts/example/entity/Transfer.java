package org.seasar.sastruts.example.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "transfer")
public class Transfer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, unique = true)
	public String id;

	@Column(name = "account_id", nullable = false, unique = false)
	public String accountId;

	@Column(name = "name", nullable = false, unique = false)
	public String name;

	@Column(name = "transfer_amount", nullable = false, unique = false)
	public long transferAmount;

	@Column(name = "transfer_date", nullable = false, unique = false)
	@Temporal(TemporalType.DATE)
	public LocalDateTime transferDate;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("id:").append(id);
		sb.append("account_id:").append(accountId);
		sb.append("name:").append(name);
		sb.append("transfer_amount:").append(transferAmount);
		sb.append("transfer_date:").append(transferDate);
		return sb.toString();
	}
}
