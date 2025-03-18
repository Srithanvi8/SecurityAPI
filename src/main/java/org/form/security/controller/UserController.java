package org.form.security.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "User Controller", description = "APIs related to user authentication")
public class UserController {

    /**
     * Injecting user service inorder to login
     */
    @Autowired
    private UserService userService;

    /**
     * Creating Login API for user login
     * @param loginDto
     * @return login dto
     */
    @PostMapping("/login")
    @Operation(summary = "Login user", description = "Authenticate user and returning JWT token in response header")
    public ResponseEntity<GenericResponseDTO<Object>> loginUser(@RequestBody LoginDto loginDto) {
        return userService.loginUser(loginDto);
    }
}