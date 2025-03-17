package org.form.security.controller;

import org.form.security.dto.LoginDto;
import org.form.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public org.form.security.dto.response.ApiResponse<Object> loginUser(@RequestBody LoginDto loginDto) {
        return userService.loginUser(loginDto);
    }
}
