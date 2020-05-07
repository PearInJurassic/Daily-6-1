package com.massizhi.daily.service.impl;

import com.massizhi.daily.dao.AreaDao;
import com.massizhi.daily.dao.PostDao;
import com.massizhi.daily.dao.UserDao;
import com.massizhi.daily.dao.UserFollowDao;
import com.massizhi.daily.entity.User;
import com.massizhi.daily.entity.UserExpand;
import com.massizhi.daily.entity.UserFollow;
import com.massizhi.daily.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private AreaDao areaDao;
    @Autowired
    private UserFollowDao userFollowDao;
    @Autowired
    private PostDao postDao;

    @Override
    public UserExpand getUserInfoByUserId(int userId) {
        UserExpand userExpand =new UserExpand();
        User user=userDao.getUserByUserId(userId);
        userExpand.setUser(user);
        if(user.getAreaId() != null && user.getAreaId() != 0)
        userExpand.setAreaName(areaDao.getAreaNameById(user.getAreaId()));
        return userExpand;
    }

    @Transactional
    @Override
    public boolean updateUserInfo(User user) {
        if (user.getUserId() != null) {
            try {
                int effectedNum = userDao.updateUser(user);
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

    @Transactional
    @Override
    public boolean cancelFollow(int userId, int followId) {
        if (userId != 0 && followId != 0) {
            try {
                int effectedNum1 = userDao.incUserFollowNum(userId);
                int effectedNum2 = userDao.incUserFansNum(followId);
                int effectedNum3 = userFollowDao.deleteUserFollowByTwoId(userId,followId);
                if (effectedNum1 > 0 && effectedNum2 > 0 && effectedNum3 > 0) {
                    return true;
                } else {
                    throw new RuntimeException("用户取消关注失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("用户取消关注失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("用户取消关注失败");
        }
    }

    @Override
    public boolean addFollow(int userId, int followId) {
        if (userId != 0 && followId != 0) {
            try {
                int effectedNum1 = userDao.decUserFollowNum(userId);
                int effectedNum2 = userDao.decUserFansNum(followId);
                UserFollow userFollow=new UserFollow();
                userFollow.setFollowTime(new Date());
                userFollow.setUserId(userId);
                userFollow.setFollowId(followId);
                int effectedNum3 = userFollowDao.insertUserFollow(userFollow);
                if (effectedNum1 > 0 && effectedNum2 > 0 && effectedNum3 > 0) {
                    return true;
                } else {
                    throw new RuntimeException("用户增加关注失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("用户增加关注失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("用户增加关注失败");
        }
    }

    @Override
    public boolean addFollowByUserIdAndPostId(int userId, int postId) {
        if (userId != 0 && postId != 0) {
            try {
                int followId=postDao.queryUserByPostId(postId);
                int effectedNum1 = userDao.decUserFollowNum(userId);
                int effectedNum2 = userDao.decUserFansNum(followId);
                UserFollow userFollow=new UserFollow();
                userFollow.setFollowTime(new Date());
                userFollow.setUserId(userId);
                userFollow.setFollowId(followId);
                int effectedNum3 = userFollowDao.insertUserFollow(userFollow);
                if (effectedNum1 > 0 && effectedNum2 > 0 && effectedNum3 > 0) {
                    return true;
                } else {
                    throw new RuntimeException("用户增加关注失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("用户增加关注失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("用户增加关注失败");
        }
    }
}
