package io.merch.amazon.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsersEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String contactNumber;
	private String alternateContactNumber;
	private String emailId;
	private String password;
	private String confirmPassword;
	private int age;
	private LocalDate dateOfBirth;

	@OneToMany(mappedBy = "usersEntity", cascade = CascadeType.ALL, orphanRemoval = true)
	@ToString.Exclude
	private List<AddressEntity> addressEntities;

	public UsersEntity(String firstName, String lastName, String contactNumber, String alternateContactNumber,
	                   String emailId, String password, String confirmPassword,
	                   LocalDate dateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.alternateContactNumber = alternateContactNumber;
		this.emailId = emailId;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.dateOfBirth = dateOfBirth;
	}
}
