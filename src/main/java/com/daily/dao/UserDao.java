package com.daily.dao;

import java.util.List;
import com.daily.entity.User;

public interface UserDao {
    String getPasswordByEmail(String email);

    int insertUser(User user);

    int delUserById(int userId);

    int freezeUserById(int userId);

    Integer existEmail(String email);
}
