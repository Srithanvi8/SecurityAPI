package org.form.security.controller;

import org.form.security.dto.LoginDto;
import org.form.security.dto.response.GenericResponseDTO;
import org.form.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is a controller class with login API
 * @Author srithanvi
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<GenericResponseDTO<Object>> loginUser(@RequestBody LoginDto loginDto) {
        return userService.loginUser(loginDto);
    }

}