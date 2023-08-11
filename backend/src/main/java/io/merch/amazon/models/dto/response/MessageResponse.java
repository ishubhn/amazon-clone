package io.merch.amazon.models.dto.response;

import io.merch.amazon.models.dto.Status;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MessageResponse {
	private LocalDateTime timestamp;
	private Status status;
	private String message;
	private String additionalMessage;

	public MessageResponse(Status status, String message, String additionalMessage) {
		this.timestamp = LocalDateTime.now();
		this.status = status;
		this.message = message;
		this.additionalMessage = additionalMessage;
	}
}
