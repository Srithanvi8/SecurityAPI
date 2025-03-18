package org.form.security.dao;

import org.form.security.model.User;

/**
 * Author Sri Thanvi
 * Creating interface inorder to reduce tight coupling
 * Create a method of findByUserName
 */
public interface UserDao {
    User findByUserName(String userName);
}
