package io.merch.amazon.models.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MessageResponse {
	private LocalDateTime timestamp;
	private String status;
	private String message;

	public MessageResponse(String status, String message) {
		this.timestamp = LocalDateTime.now();
		this.status = status;
		this.message = message;
	}
}
