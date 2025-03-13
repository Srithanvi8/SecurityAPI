package org.form.security.dao;

import org.form.security.model.User;

public interface UserDao {
    User findByUserName(String userName);
}
