package org.form.security.controller;

import org.form.security.dao.impl.UserDaoImpl;
import org.form.security.dto.LoginDto;
import org.form.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserDaoImpl userDaoImpl;

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginDto loginDto) {
        User user = userDaoImpl.findByUserName(loginDto.getUserName());
        if (user != null && user.getPassword().equals(loginDto.getPassword()))  {
            return ResponseEntity.ok("Login successful!");
        }
        return ResponseEntity.ok("Invalid credentials. Please try again.");
    }
}
