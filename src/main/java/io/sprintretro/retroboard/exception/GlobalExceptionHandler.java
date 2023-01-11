package io.sprintretro.retroboard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoResourceException.class)
    public ResponseEntity<NoResponse> resourceNotFoundExceptionHandler(NoResourceException ex, WebRequest webRequest) {
        String message = ex.getMessage();
        NoResponse apiResponse = new NoResponse(LocalDateTime.now(), message, HttpStatus.NOT_FOUND.toString(), webRequest.getDescription(false));
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> violations = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();

            violations.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(violations, HttpStatus.BAD_REQUEST);
    }
}