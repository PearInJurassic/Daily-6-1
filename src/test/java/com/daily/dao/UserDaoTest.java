package com.daily.dao;
import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.daily.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行

public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void testInsertUser() {
        User user=new User();

        user.setUserType(0);
        user.setUserName("name");
        user.setUserPwd("password");
        user.setUserImg("img");
        user.setAreaId(1);
        user.setUserDate(new Date());
        user.setGender("g");
        user.setProfile("profile");
        user.setState(0);
        user.setFansNum(0);
        user.setFollowNum(0);
        int i=userDao.insertUser(user);
        assertEquals(1,i);
    }

    @Test
    public void testGetPasswordByName() {
        String password="cccp";
        String email="msn";
        assertEquals(password,userDao.getPasswordByEmail(email));
    }

    @Test
    public void testDelUserById(){
        int userId=4;
        int i = userDao.delUserById(userId);
        assertEquals(1,i);
    }

    @Test
    public void testFreezeById(){
        int userId=1;
        int i = userDao.freezeUserById(1);
        assertEquals(1,i);
    }

    @Test
    public void testExistEmail(){
        String email="email@example.com";
        Integer r1=userDao.existEmail(email);
        System.out.println(r1);
        assertEquals(1,r1.intValue());
    }
}
