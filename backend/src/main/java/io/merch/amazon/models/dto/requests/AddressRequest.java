package io.merch.amazon.models.dto.requests;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AddressRequest {
	private String flatNo;
	private String address;
	private String pinCode;
	private String city;
	private String state;
	private String country;
}
