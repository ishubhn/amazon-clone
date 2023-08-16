package io.merch.amazon.models.dto.requests;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDeleteRequest {
	private String userEmailId;
	private String contactNumber;
}
