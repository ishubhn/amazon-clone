package io.merch.amazon.models.dto.response;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AddressResponse {
	private UUID id;
	private String flatNo;
	private String address;
	private String pinCode;
	private String city;
	private String state;
	private String country;
}
