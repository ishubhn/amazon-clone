package io.merch.amazon.models.dto.response;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserResponse {
	private UUID id;
	private String firstName;
	private String lastName;
	private String contactNumber;
	private String alternateContactNumber;
	private String emailId;
	private String age;
	private List<AddressResponse> addressResponse;
}
