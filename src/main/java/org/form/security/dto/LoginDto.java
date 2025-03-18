package org.form.security.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created a class to send data in body
 * Using lombok to avoid lengthy code
 */
@Getter
@Setter
public class LoginDto {
    private String userName;
    private String password;
}
