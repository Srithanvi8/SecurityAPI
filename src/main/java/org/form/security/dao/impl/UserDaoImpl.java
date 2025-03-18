package org.form.security.dao.impl;

import org.form.security.dao.UserDao;
import org.form.security.dao.repo.UserRepository;
import org.form.security.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Creating Repository inorder to reduce tight coupling
 */
@Repository
    public class UserDaoImpl implements UserDao {

        private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    /**
     * Injecting User Repository
     */
    @Autowired
        private UserRepository userRepository;

    /**
     * Implementing Dao methods
     * @param userName
     * @return username if available or else null
     */
        @Override
        public User findByUserName(String userName) {
            try {
                return userRepository.findByUserName(userName).orElse(null);
            } catch (Exception e) {
                logger.error("Error fetching user: {}", e.getMessage());
                return null;
            }
        }
    }
