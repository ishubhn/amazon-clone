package io.merch.amazon.models;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "ADDRESS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String flatNo;
	private String address;
	private String pinCode;
	private String city;
	private String state;
	private String country;

	@ManyToOne
	@JoinColumn(name = "users_id")
	private UsersEntity usersEntity;

}
