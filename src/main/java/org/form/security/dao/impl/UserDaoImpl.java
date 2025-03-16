package org.form.security.dao.impl;

import lombok.extern.slf4j.Slf4j;
import org.form.security.dao.UserDao;
import org.form.security.dao.repo.UserRepository;
import org.form.security.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class UserDaoImpl implements UserDao {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUserName(String userName) {
        try {
            return userRepository.findByUserName(userName).orElse(null);
        } catch (Exception e) {
            log.error("Error fetching user: {}", e.getMessage());
            return null;
        }
    }
}

