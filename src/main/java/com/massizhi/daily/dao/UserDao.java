package com.massizhi.daily.dao;

import com.massizhi.daily.entity.User;

public interface UserDao {
    /*
     * 通过用户ID得到用户信息
     *
     * @param userId
     * @return User
     */
    User getUserByUserId(int userId);

}
