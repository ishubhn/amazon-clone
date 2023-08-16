package io.merch.amazon.models.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserResponse {
	private Long id;
	private String firstName;
	private String lastName;
	private String contactNumber;
	private String alternateContactNumber;
	private String emailId;
	private int age;
	private List<AddressResponse> addressResponse;
}
