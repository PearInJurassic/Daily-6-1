package com.daily.dao;

import com.daily.entity.Post;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行

public class PostDaoTest {
    // 通过spring容器注入Dao的实现类
    @Autowired
    private PostDao postDao;

    @Test
    @Ignore
    public void testQueryPost() {
        List<Post> areaList = postDao.queryPost();
        // 验证预期值和实际值是否相符
        assertEquals(1, areaList.size());
    }

    @Test
    @Ignore
    public void testQueryPostByUserId() {
        List<Post> area = postDao.queryPostByUserId(1);
        assertEquals(1, area.size());
    }

    @Test
    @Ignore
    public void testQueryUserByPostId() {
        int i = postDao.queryUserByPostId(1);
        assertEquals(1, i);
    }

    @Test
    @Ignore
    public void testInsertPost() {
        Post post = new Post();
        post.setAnonym(0);
        post.setAreaId(2);
        post.setPostContent("xixi天气有点热");
        post.setPostCreateTime(new Date());
        post.setPostUpdateTime(new Date());
        //post.setForward(0);
        post.setUserId(2);
        int i = postDao.insertPost(post);
        assertEquals(1, i);
    }

    @Test
    @Ignore
    public void testUpdatePost() {
        List<Post> postList = postDao.queryPost();
        for (Post post : postList) {
            if ("哼".equals(post.getPostContent())) {

                post.setPostContent("hahahah");
                int effectedNum = postDao.updatePost(post);
                assertEquals(1, effectedNum);
            }
        }

    }

    @Test
    @Ignore
    public void testDeletePost() {
        List<Post> postList = postDao.queryPost();
        for (Post post : postList) {
            if ("hahahah".equals(post.getPostContent())) {
                int effectedNum = postDao.deletePost(post.getPostId());
                assertEquals(1, effectedNum);
            }
        }

    }

    @Test
    @Ignore
    public void testIncCommentNum() {
        int i = postDao.incCommentNum(4);
        assertEquals(1, i);
    }

    @Test
    @Ignore
    public void testDecCommentNum() {
        int i = postDao.decCommentNum(4);
        assertEquals(1, i);
    }

    @Test
    @Ignore
    public void testQueryCommentNum() {
        int i = postDao.queryCommentNum(1);
        assertEquals(3, i);
    }

    @Test
    @Ignore
    public void testIncLikeNum() {
        int i = postDao.incLikeNum(4);
        assertEquals(1, i);
    }

    @Test
    @Ignore
    public void testDecLikeNum() {
        int i = postDao.decLikeNum(4);
        assertEquals(1, i);
    }

    @Test
    @Ignore
    public void testQueryLikeNum() {
        int i = postDao.queryLikeNum(1);
        assertEquals(2, i);
    }

    @Test
    @Ignore
    public void testIncTipoffNum() {
        int i = postDao.incTipoffNum(4);
        assertEquals(1, i);
    }

    @Test
    @Ignore
    public void testDecTipoffNum() {
        int i = postDao.decTipoffNum(4);
        assertEquals(1, i);
    }

    @Test
    @Ignore
    public void testQueryTipoffNum() {
        int i = postDao.queryTipoffNum(4);
        assertEquals(0, i);
    }

    @Test
    public void testIncForwardNum() {
        int i = postDao.incForwardNum(4);
        assertEquals(1, i);
    }

    @Test
    public void testDecForwardNum() {
        int i = postDao.decForwardNum(4);
        assertEquals(1, i);
    }

    @Test
    public void testQueryForwardNum() {
        int i = postDao.queryForwardNum(4);
        assertEquals(0, i);
    }

    @Test
    public void testQueryPostByContent() {
        List<Post> postList = postDao.queryPostByContent("测试");
        for (Post post : postList) {
            System.out.println(post.getPostContent());
        }
    }

    @Test
    public void testQueryPostByContentAndUserId() {
        List<Post> postList = postDao.queryPostByContentAndUserId("测试", 1);
        for (Post post : postList) {
            System.out.println(post.getPostContent());
        }
    }

    @Test
    public void testCountPostNumByUserId(){
        int num=postDao.countPostNumByUserId(7);
        System.out.println(num);
    }
}
