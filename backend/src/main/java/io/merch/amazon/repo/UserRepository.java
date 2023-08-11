package io.merch.amazon.repo;

import io.merch.amazon.models.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, UUID> {
	Optional<UsersEntity> findByEmailId(String emailId);

	Optional<UsersEntity> findByContactNumber(String contactNumber);

	@Query(value = "SELECT * FROM users WHERE first_name LIKE %?1% OR last_name LIKE %?1%", nativeQuery = true)
	List<UsersEntity> findByFirstNameOrLastName(String name);
}
