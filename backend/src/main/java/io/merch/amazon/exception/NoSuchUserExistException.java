package io.merch.amazon.exception;

public class NoSuchUserExistException extends RuntimeException {
	public NoSuchUserExistException(String s) {
		super(s);
	}
}
