package org.form.security.service;

import org.form.security.config.JwtUtil;
import org.form.security.dao.UserDao;
import org.form.security.dto.LoginDto;
import org.form.security.dto.response.ApiResponse;
import org.form.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private final UserDao userDao;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public ApiResponse<Object> loginUser(LoginDto loginDto) {
        User user = userDao.findByUserName(loginDto.getUserName());

        if (user == null) {
            return new ApiResponse<>(false, "User not found", new Date(), null);
        }

        if (!passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
            return new ApiResponse<>(false, "Invalid credentials", new Date(), null);
        }

        String token = jwtUtil.generateToken(user.getUserName());
        return new ApiResponse<>(true, "Login successful!", new Date(), token);
    }
}
