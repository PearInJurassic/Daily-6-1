package com.massizhi.daily.service;

import com.massizhi.daily.entity.User;
import com.massizhi.daily.entity.UserExpand;

public interface UserService {
    /*
     * 通过用户ID得到用户信息
     * 提示：在这里将用户地区ID转化为地区名
     * @param userId
     * @return User
     */
    UserExpand getUserInfoByUserId(int userId);
    /*
     * 修改用户信息
     *
     * @param user
     * @return boolean
     */
    boolean updateUserInfo(User user);
}
