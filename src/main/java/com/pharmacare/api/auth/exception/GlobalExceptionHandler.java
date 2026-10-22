package com.pharmacare.api.auth.exception;

import com.pharmacare.api.auth.response.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/** Converts exceptions from controllers and services into consistent HTTP error responses. */
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Bean-validation failures are client errors, so return HTTP 400 with a useful message.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationException(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors().stream()
                .findFirst()
                .map(error -> error.getDefaultMessage())
                .orElse("Validation failed");

        return ResponseEntity.badRequest().body(new ApiError(400, "Bad Request", message));
    }

    // Service-level invalid input (for example, an invalid refresh token) also maps to HTTP 400.
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(new ApiError(400, "Bad Request", ex.getMessage()));
    }

    // Keep unexpected failures in one response shape instead of exposing stack traces.
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ApiError(500, "Internal Server Error", ex.getMessage()));
    }
}
