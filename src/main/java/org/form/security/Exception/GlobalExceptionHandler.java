package org.form.security.Exception;
import org.form.security.dto.response.GenericResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handling the unknown exceptions in this project
     * @param e
     * @return response as a bad request
     */
    @ExceptionHandler(RuntimeException.class)
    public org.springframework.http.ResponseEntity<GenericResponseDTO<Object>> handleRuntimeException(RuntimeException e) {
        GenericResponseDTO<Object> response = new GenericResponseDTO<>(false, e.getMessage(), new Date(), null);
        return new org.springframework.http.ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}