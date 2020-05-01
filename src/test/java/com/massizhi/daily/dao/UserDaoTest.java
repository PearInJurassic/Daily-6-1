package com.massizhi.daily.dao;

import com.massizhi.daily.entity.User;
import com.massizhi.daily.entity.UserFollowInfo;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class UserDaoTest {
    //通过spring容器注入Dao的实现类
    @Autowired
    private UserDao userDao;

    @Test
    void getUserByUserId() {
        User user= userDao.getUserByUserId(1);
        // 验证预期值和实际值是否相符
        assertEquals("123456", user.getUserPwd());
    }

    @Test
    void getUserFollowInfoByUserId() {
        UserFollowInfo userFollowInfo = userDao.getUserFollowInfoByUserId(1);
        // 验证预期值和实际值是否相符
        assertEquals("哈哈", userFollowInfo.getUserName());
    }

    @Test
    void updateUser() {
        User temp=new User();
        temp.setUserId(1);
        temp.setUserName("哈哈");
        userDao.updateUser(temp);
        User user= userDao.getUserByUserId(1);
        // 验证预期值和实际值是否相符
        assertEquals("哈哈", user.getUserName());
    }
}