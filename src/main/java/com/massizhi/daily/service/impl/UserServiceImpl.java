package com.massizhi.daily.service.impl;

import com.massizhi.daily.dao.AreaDao;
import com.massizhi.daily.dao.UserDao;
import com.massizhi.daily.entity.User;
import com.massizhi.daily.entity.UserExpand;
import com.massizhi.daily.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    private AreaDao areaDao;

    @Override
    public UserExpand getUserInfoByUserId(int userId) {
        UserExpand userExpand =new UserExpand();
        User user=userDao.getUserByUserId(userId);
        userExpand.setUser(user);
        userExpand.setAreaName(areaDao.getAreaNameById(user.getAreaId()));
        return userExpand;
    }

    @Transactional
    @Override
    public boolean updateUserInfo(User user) {
        if (user.getUserId() != null) {
            try {
                int effectedNum = userDao.updateUser(user);;
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("用户信息更新失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("用户信息更新失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("用户信息更新失败");
        }
    }
}
