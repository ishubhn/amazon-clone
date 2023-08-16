package io.merch.amazon.repo;

import io.merch.amazon.models.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
	@Query(value = "SELECT * FROM ADDRESS WHERE USERS_ID = ?1", nativeQuery = true)
	List<AddressEntity> findAddressByUsersId(String id);
}
