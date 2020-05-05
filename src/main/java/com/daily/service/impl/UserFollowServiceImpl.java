package com.daily.service.impl;

import com.daily.dao.UserDao;
import com.daily.dao.UserFollowDao;
import com.daily.entity.UserFollowInfo;
import com.daily.service.UserFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserFollowServiceImpl implements UserFollowService {
    @Autowired
    private UserDao userDao;
    private UserFollowDao userFollowDao;

    @Override
    public List<UserFollowInfo> getUserFollowInfoByUserId(int userId) {
        List<UserFollowInfo> list=new ArrayList<UserFollowInfo>();
        List<Integer> userFollowIDList=userFollowDao.getUserFollowIDListByUserId(userId);
        for(int i=0;i<userFollowIDList.size();i++) {
            int userFollowID=userFollowIDList.get(i);
            UserFollowInfo userFollowInfo=userDao.getUserFollowInfoByUserId(userFollowID);
            list.add(userFollowInfo);
        }
        return list;
    }
}
