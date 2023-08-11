package io.merch.amazon.models.dto.request;

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
