package io.merch.amazon.services.impl;

import io.merch.amazon.models.dto.requests.AddressRequest;
import io.merch.amazon.models.dto.response.AddressResponse;
import io.merch.amazon.models.dto.response.MessageResponse;
import io.merch.amazon.services.UserAddressService;

import java.util.List;
import java.util.UUID;

public class UserAddressServiceImpl implements UserAddressService {
	@Override
	public List<AddressResponse> getAddressListForUser(UUID userId) {
		return null;
	}

	@Override
	public MessageResponse addAddresstoUser(String userId, AddressRequest request) {
		return null;
	}
}
