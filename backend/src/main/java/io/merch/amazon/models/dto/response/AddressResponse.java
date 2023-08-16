package io.merch.amazon.models.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AddressResponse {
	private Long id;
	private String flatNo;
	private String address;
	private String pinCode;
	private String city;
	private String state;
	private String country;
}
