package com.massizhi.daily.dao;

import com.massizhi.daily.entity.Post;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class PostDaoTest {
    //通过spring容器注入Dao的实现类
    @Autowired
    private PostDao postDao ;

    @Test
    void queryPostByUserId() {
        List<Post> postList=postDao.queryPostByUserId(2);
        assertEquals(3, postList.size());
    }

    @Test
    void queryPostByContentAndUserId() {
        List<Post> postList=postDao.queryPostByContentAndUserId("这是",2);
        assertEquals(2, postList.size());
    }

    @Test
    void queryUserByPostId() {
        int i=postDao.queryUserByPostId(3);
        assertEquals(2, i);
    }
}