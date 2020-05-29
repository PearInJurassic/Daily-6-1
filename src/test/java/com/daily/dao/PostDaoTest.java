package com.daily.dao;

import com.daily.entity.Post;
import com.daily.service.PostService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostDaoTest {
    @Autowired
    private PostDao postDao;

    @Test
    public void deletePost() {
        assertEquals(1,postDao.deletePost(12));
    }
}