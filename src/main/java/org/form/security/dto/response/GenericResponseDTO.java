package org.form.security.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenericResponseDTO<T> {
    private boolean status;
    private String message;
    private Date timestamp;
    private T result;
}
