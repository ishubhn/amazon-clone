package io.merch.amazon.models;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

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
	private Long id;
	private String flatNo;
	private String address;
	private String pinCode;
	private String city;
	private String state;
	private String country;

	@ManyToOne
	@JoinColumn(name = "users_id")
	private UsersEntity usersEntity;

	public AddressEntity(String flatNo, String address, String pinCode, String city, String state, String country) {
		this.flatNo = flatNo;
		this.address = address;
		this.pinCode = pinCode;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AddressEntity that = (AddressEntity) o;
		return Objects.equals(flatNo, that.flatNo) &&
				Objects.equals(address, that.address) &&
				Objects.equals(pinCode, that.pinCode) &&
				Objects.equals(city, that.city) &&
				Objects.equals(state, that.state) &&
				Objects.equals(country, that.country);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, flatNo, address, pinCode, city, state, country);
	}
}
