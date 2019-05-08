package org.seasar.sastruts.example.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorDto {
	private final String status;
	private final List<String> messages;

	public ErrorDto(@JsonProperty("Status") String status,
					@JsonProperty("Messages") List<String> messages) {
		this.status = status;
		this.messages = messages;
	}

	public String getStatus() {
		return status;
	}
	public List<String> getMessages() {
		return messages;
	}
}
