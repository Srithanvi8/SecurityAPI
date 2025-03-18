package org.form.security.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Creating GenericResponse DTO for getting response in a proper format
 * @param <T>
 * Using lombok to avoid lengthy code
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericResponseDTO<T> {
    private boolean status;
    private String message;
    private Date timestamp;
    private T result;
}
