package io.merch.amazon.models.dto.response;

import io.merch.amazon.models.dto.Status;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MessageResponse {
	private LocalDateTime timestamp;
	@NonNull private Status status;
	@NonNull private String message;
	private String additionalMessage;

	public MessageResponse(String status, String message, String additionalMessage) {
		this.timestamp = LocalDateTime.now();
		this.status = Status.valueOf(status);
		this.message = message;
		this.additionalMessage = additionalMessage;
	}
}
