package io.merch.amazon.models.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserRequest {
	private String firstName;
	private String lastName;
	private String contactNumber;
	private String alternateContactNumber;
	private String emailId;
	private String password;
	private String confirmPassword;
	private LocalDate dateOfBirth;

	public UserRequest(String firstName, String lastName, String contactNumber, String alternateContactNumber,
	                   String emailId, String password, String confirmPassword, String dateOfBirth) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.alternateContactNumber = alternateContactNumber;
		this.emailId = emailId;
		this.password = password;
		this.confirmPassword = confirmPassword;

		// convert string to date
		String[] token = dateOfBirth.split("-");
		this.dateOfBirth = LocalDate.of(Integer.parseInt(token[0]),
								Integer.parseInt(token[1]),
								Integer.parseInt(token[2]));
	}


}
