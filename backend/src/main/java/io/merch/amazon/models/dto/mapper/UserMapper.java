package io.merch.amazon.models.dto.mapper;

import io.merch.amazon.models.UsersEntity;
import io.merch.amazon.models.dto.request.UserRequest;
import io.merch.amazon.models.dto.response.UserResponse;
import lombok.NoArgsConstructor;

public class UserMapper {
	private UserMapper() {}

	public static UsersEntity toUsersEntity(UserRequest request) {
		return new UsersEntity(request.getFirstName(), request.getLastName(), request.getContactNumber(),
				request.getAlternateContactNumber(), request.getEmailId(), request.getPassword(),
				request.getConfirmPassword(), request.getDateOfBirth());
	}

	public static UserResponse toUsersResponse(UsersEntity entity) {
		return new UserResponse(entity.getId(), entity.getFirstName(), entity.getLastName(), entity.getContactNumber(),
				entity.getAlternateContactNumber(), entity.getEmailId(), entity.getAge(),
				AddressMapper.toAddressResponse(entity.getAddressEntities()));
	}
}
