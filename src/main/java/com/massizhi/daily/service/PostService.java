package com.massizhi.daily.service;

import com.massizhi.daily.entity.Post;

import java.util.List;

public interface PostService {
    /**
     * 通过发帖人Id获取帖子信息
     *
     * @param areaId
     * @return
     */
    List<Post> getPostByUserId(int userId);

    List<Post> getPostByContentAndUserId(String str, int userId);
}
