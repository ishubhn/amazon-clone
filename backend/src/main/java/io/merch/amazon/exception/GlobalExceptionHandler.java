package io.merch.amazon.exception;

import io.merch.amazon.models.dto.Status;
import io.merch.amazon.models.dto.response.MessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(InvalidArgumentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public MessageResponse handleInvalidArgumentException(InvalidArgumentException ex, WebRequest request) {
		return new MessageResponse(Status.FAILURE, ex.getMessage(), request.getDescription(true));
	}

	@ExceptionHandler(InvalidAgeException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public MessageResponse handleInvalidAgeException(InvalidAgeException ex, WebRequest request) {
		return new MessageResponse(Status.FAILURE, ex.getMessage(), request.getDescription(true));
	}

	@ExceptionHandler(NoSuchUserExistException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public MessageResponse handleNoSuchUserExistException(NoSuchUserExistException ex, WebRequest request) {
		return new MessageResponse(Status.FAILURE, ex.getMessage(), request.getDescription(true));
	}
}
