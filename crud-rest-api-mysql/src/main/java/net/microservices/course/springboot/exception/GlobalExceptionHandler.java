package net.microservices.course.springboot.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(
            ResourceNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTimestamp(LocalDateTime.now());
        errorDetails.setMessage(ex.getMessage());
        errorDetails.setPath(request.getDescription(false));
        errorDetails.setErrorCode("USER_NOT_FOUND");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmailAlreadyExistException.class)
    public ResponseEntity<ErrorDetails> handleEmailAlreadyExistException(
            EmailAlreadyExistException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTimestamp(LocalDateTime.now());
        errorDetails.setMessage(ex.getMessage());
        errorDetails.setPath(request.getDescription(false));
        errorDetails.setErrorCode("EMAIL_ALREADY_EXISTS");
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setTimestamp(LocalDateTime.now());
        errorDetails.setMessage(ex.getMessage());
        errorDetails.setPath(request.getDescription(false));
        errorDetails.setErrorCode("INTERNAL_SERVER_ERROR");
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
