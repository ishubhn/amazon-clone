package io.merch.amazon.services;

import io.merch.amazon.models.dto.requests.AddressRequest;
import io.merch.amazon.models.dto.response.AddressResponse;
import io.merch.amazon.models.dto.response.MessageResponse;

import java.util.List;
import java.util.UUID;

public interface UserAddressService {
	List<AddressResponse> getAddressListForUser(UUID userId);

	MessageResponse addAddresstoUser(String userId, AddressRequest request);
}
