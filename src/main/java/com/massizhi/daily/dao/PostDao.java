package com.massizhi.daily.dao;

import com.massizhi.daily.entity.Post;

import java.util.List;

public interface PostDao {
    /*
     * 根据用户ID得到帖子列表
     *
     * @param userId
     * @return List<Post>
     */
    List<Post> getPostListByAreaId(int userId);
}
