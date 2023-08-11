package io.merch.amazon.exception;

import io.merch.amazon.models.dto.Status;

public class NoSuchUserExistException extends RuntimeException {
	public NoSuchUserExistException(String s) {
		super(s);
	}

}
