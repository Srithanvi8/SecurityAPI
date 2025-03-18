package org.form.security.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.form.security.dao.UserDao;
import org.form.security.dto.LoginDto;
import org.form.security.dto.response.GenericResponseDTO;
import org.form.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {

    @Autowired
    private final UserDao userDao;


    private final String SECRET_KEY = "6PfhoGv/MEZsuvD2dp72Y47Lhv/KvGnhTwyVp/Q87PE="; // Secret key for signing JWT

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public ResponseEntity<GenericResponseDTO<Object>> loginUser(LoginDto loginDto) {
        User user = userDao.findByUserName(loginDto.getUserName());

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new GenericResponseDTO<>(false, "User not found", new Date(), null));
        }

        if (!user.getPassword().equals(loginDto.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new GenericResponseDTO<>(false, "Invalid credentials", new Date(), null));
        }

        String token = Jwts.builder()
                .setSubject(user.getUserName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);

        return ResponseEntity.ok()
                .headers(headers)
                .body(new GenericResponseDTO<>(true, "Login successful!", new Date(), null));
    }
}