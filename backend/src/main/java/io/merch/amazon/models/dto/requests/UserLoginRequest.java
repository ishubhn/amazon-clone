package io.merch.amazon.models.dto.requests;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserLoginRequest {
	private String emailId;
	private String contactNumber;
	private String password;
}
