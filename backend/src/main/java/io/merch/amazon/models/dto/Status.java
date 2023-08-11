package io.merch.amazon.models.dto;

public enum Status {
	SUCCESS("SUCCESS"),
	FAILURE("FAILURE");

	private final String value;

	Status(String value) {
		this.value = value;
	}
}
