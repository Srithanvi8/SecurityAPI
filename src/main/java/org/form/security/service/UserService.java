package org.form.security.service;

import org.form.security.dao.repo.UserRepository;
import org.form.security.dto.LoginDto;
import org.form.security.dto.response.ResponseEntity;
import org.form.security.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity loginUser(LoginDto loginDto) {
        User user = userRepository.findByUserName(loginDto.getUserName())
                .orElse(null);

        if (user == null) {
            return new ResponseEntity(false, "User not found");
        }

        if (!user.getPassword().equals(loginDto.getPassword())) {
            return new ResponseEntity(false, "Invalid credentials");
        }

        return new ResponseEntity(true, "Login Successful");
    }
}
