package com.massizhi.daily.dao;

import com.massizhi.daily.entity.User;
import com.massizhi.daily.entity.UserFollowInfo;

public interface UserDao {
    /*
     * 通过用户ID得到用户信息
     *
     * @param userId
     * @return User
     */
    User getUserByUserId(int userId);
    /* 针对关注用户的信息使用！！！
     * 通过关注用户ID得到用户信息
     *
     * @param userId
     * @return UserFollowInfo
     */
    UserFollowInfo getUserFollowInfoByUserId(int userId);
    /*
     * 修改用户信息
     *
     * @param user
     * @return int
     */
    int updateUser(User user);
}
