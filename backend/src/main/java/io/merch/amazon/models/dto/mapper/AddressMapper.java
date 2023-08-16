package io.merch.amazon.models.dto.mapper;

import io.merch.amazon.models.AddressEntity;
import io.merch.amazon.models.dto.requests.AddressRequest;
import io.merch.amazon.models.dto.response.AddressResponse;

import java.util.ArrayList;
import java.util.List;

public class AddressMapper {
	private AddressMapper() {}

	public static AddressEntity toAddressEntity(AddressRequest request) {
		return new AddressEntity(request.getFlatNo(), request.getAddress(), request.getPinCode(), request.getCity(),
				request.getState(), request.getCountry());
	}

	public static List<AddressResponse> toAddressResponse(List<AddressEntity> entity) {
		List<AddressResponse> responses = new ArrayList<>();

		// for each address entity map to response and return as list
		for (AddressEntity e : entity) {
			responses.add(new AddressResponse(e.getId(), e.getFlatNo(), e.getAddress(), e.getPinCode(),
					e.getCity(), e.getState(), e.getCountry()));
		}

		return responses;
	}
}
