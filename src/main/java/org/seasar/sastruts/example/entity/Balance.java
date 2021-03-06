package org.seasar.sastruts.example.entity;

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
@Table(name = "balance")
public class Balance {
	@Id
	@Column(name = "account_id", nullable = false, unique = true)
	public String accountId;

	@Column(name = "amount", nullable = false, unique = false)
	public long amount;
	
	@Column(name = "name", nullable = false, unique = false)
	public String name;

	@Column(name = "created_at", nullable = false, unique = false)
	@Temporal(TemporalType.DATE)
	public Date createdAt;

	@Column(name = "updated_at", nullable = true, unique = false)
	@Temporal(TemporalType.DATE)
	public Date updatedAt;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("account_id:").append(accountId);
		sb.append("name:").append(name);
		sb.append("created_at:").append(createdAt);
		sb.append("updated_at:").append(updatedAt);
		return sb.toString();
	}
}
