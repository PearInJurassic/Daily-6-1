package com.massizhi.daily.service.impl;

import com.massizhi.daily.dao.PostDao;
import com.massizhi.daily.dao.UserDao;
import com.massizhi.daily.entity.Post;
import com.massizhi.daily.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostDao postDao;

    @Override
    public List<Post> getPostByUserId(int userId) {
        return postDao.queryPostByUserId(userId);
    }

    @Override
    public List<Post> getPostByContentAndUserId(String str, int userId) {
        return postDao.queryPostByContentAndUserId(str, userId);
    }
}
