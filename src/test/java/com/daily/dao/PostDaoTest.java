package com.daily.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.daily.entity.Post;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行

public class PostDaoTest {
    // 通过spring容器注入Dao的实现类
    @Autowired
    private PostDao postDao;

    @Test
    public void testAQueryPost() {
        List<Post> areaList = postDao.queryPost();
        // 验证预期值和实际值是否相符
        assertEquals(1, areaList.size());
    }

    @Test
    public void testCQueryPostByUserId() {
        List<Post> area = postDao.queryPostByUserId(1);
        assertEquals(1, area.size());
    }

    @Test
    public void testCUpdateCommentNum() {
        int i = postDao.updateCommentNum(1);
        assertEquals(1, i);
    }

    @Test
    public void testQueryCommentNum() {
        int i = postDao.queryCommentNum(1);
        assertEquals(3, i);
    }
}
