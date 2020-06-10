package com.daily.dao;

import com.daily.entity.UserFollow;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserFollowDaoTest {
    //通过spring容器注入Dao的实现类
    @Autowired
    private UserFollowDao userFollowDao;

    @Test
    @Ignore
    public void getUserFollowIDListByUserId() {
        List<Integer> userFollowList = userFollowDao.getUserFollowIDListByUserId(520);
        // 验证预期值和实际值是否相符
        assertEquals(2, userFollowList.size());
    }

    @Test
    @Ignore
    public void getUserFansIDListByUserId() {
        List<Integer> userList = userFollowDao.getUserFansIDListByUserId(101);
        // 验证预期值和实际值是否相符
        assertEquals(2, userList.size());
    }

    @Test
    @Ignore
    public void getUserFollowByTwoId() {
        UserFollow userFollow= userFollowDao.getUserFollowByTwoId(520,1314);
        int num=userFollow.getUserFollowId();
        // 验证预期值和实际值是否相符
        assertEquals(2, num);
    }

    @Test
    @Ignore
    public void isFollowByTwoId() {
        int num= userFollowDao.isFollowByTwoId(102,1);
        // 验证预期值和实际值是否相符
        assertEquals(0, num);
    }

    @Test
    @Ignore
    public void insertUserFollow() {
        //创建一个对象
        UserFollow userFollow = new UserFollow();
        userFollow.setUserId(45);
        userFollow.setFollowId(448);
        userFollow.setFollowTime(new Date());
        //将该对象实例添加入库
        int effectedNum = userFollowDao.insertUserFollow(userFollow);
        //检测影响行数
        assertEquals(1, effectedNum);
    }

    @Test
    @Ignore
    public void deleteUserFollowByTwoId() {
        int effectedNum = userFollowDao.deleteUserFollowByTwoId(44,448);
        //检测影响行数
        assertEquals(1, effectedNum);
    }
}