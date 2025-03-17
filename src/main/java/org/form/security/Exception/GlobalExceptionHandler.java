package org.form.security.Exception;
import org.form.security.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public org.springframework.http.ResponseEntity<ApiResponse<Object>> handleRuntimeException(RuntimeException e) {
        ApiResponse<Object> response = new ApiResponse<>(false, e.getMessage(), new Date(), null);
        return new org.springframework.http.ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}