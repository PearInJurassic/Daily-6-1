package com.daily.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
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
    public void testQueryPost() {
        List<Post> areaList = postDao.queryPost();
        // 验证预期值和实际值是否相符
        assertEquals(1, areaList.size());
    }

    @Test
    public void testQueryPostByUserId() {
        List<Post> area = postDao.queryPostByUserId(1);
        assertEquals(1, area.size());
    }

    @Test
    public void testQueryUserByPostId() {
        int i = postDao.queryUserByPostId(1);
        assertEquals(1, i);
    }

    @Test
    public void testInsertPost() {
        Post post = new Post();
        post.setAnonym(0);
        post.setAreaId(2);
        post.setPostContent("这是一个测试，天气有点热");
        post.setPostCreateTime(new Date());
        post.setPostUpdateTime(new Date());
        post.setForward(0);
        post.setUserId(2);
        int i = postDao.insertPost(post);
        assertEquals(1, i);
    }

    @Test
    public void testUpdatePost() {
        Post post = new Post();
        post.setAnonym(0);
        post.setAreaId(2);
        post.setPostContent("我再修改啊，烦");

        post.setPostUpdateTime(new Date());

        int i = postDao.updatePost(post);
        assertEquals(1, i);
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

    @Test
    public void testLikeCommentNum() {
        int i = postDao.updateLikeNum(1);
        assertEquals(1, i);
    }

    @Test
    public void testQueryLikeNum() {
        int i = postDao.queryLikeNum(1);
        assertEquals(2, i);
    }

}
