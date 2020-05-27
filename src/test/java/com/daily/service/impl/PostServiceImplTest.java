package com.daily.service.impl;

import com.daily.entity.Post;
import com.daily.service.PostService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
}