package com.daily.service.impl;

import com.daily.entity.Post;
import com.daily.service.PostService;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PostServiceImplTest {
    @Autowired
    private PostService postService;

    @Test
    void sortList() {
        List<Post> postList = postService.getPostList();
        postList = postService.sortList(postList);
        for(Post post : postList) {
            System.out.print(post.getPostContent());
            System.out.print(":");
            System.out.println(post.getPopularity());
        }
    }

    @Test
    @Ignore
    public void addPost() {
        Post post = new Post();
        post.setAnonym(0);
        post.setAreaId(101001);
        post.setForwardPostId(-1);
        post.setPostContent("测试新增气泡数");
        post.setUserId(1);
        post.setForwardNum(0);
        post.setTipoffNum(0);
        postService.addPost(post);
    }

    @Test
    public void deletePost() {
        assertEquals(true,postService.deletePost(13));
    }
}