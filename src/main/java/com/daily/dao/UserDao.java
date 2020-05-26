package com.daily.dao;

import com.daily.entity.User;
import com.daily.entity.UserFollowInfo;

public interface UserDao {
    String getPasswordByEmail(String email);

    Integer getUserIdByEmail(String email);

    Integer getUserTypeByEmail(String email);

    User getUserByEmail(String email);

    int insertUser(User user);

    int delUserById(int userId);

    int freezeUserById(int userId);

    int getStateByUserId(int userId);

    Integer existEmail(String email);

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
     * 用户粉丝数++
     *
     * @param userId
     * @return int
     */
    int decUserFansNum(int userId);

    /*
     * 用户粉丝数--
     *
     * @param userId
     * @return int
     */
    int incUserFansNum(int userId);

    /*
     * 用户关注数++
     *
     * @param userId
     * @return int
     */
    int decUserFollowNum(int userId);

    /*
     * 用户关注数--
     *
     * @param userId
     * @return int
     */
    int incUserFollowNum(int userId);

    /*
     * 修改用户信息
     *
     * @param user
     * @return int
     */
    int updateUser(User user);
}
