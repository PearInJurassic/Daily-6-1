package com.daily.dao;

import com.daily.entity.Post;

import java.util.List;

public interface PostDao {
    /*
     * 根据地区ID得到帖子列表
     *
     * @param areaId
     * @return List<Post>
     */
    List<Post> getPostListByAreaId(int areaId);

    /*
     * 根据地区ID得到帖子信息
     *
     * @param areaId
     * @return Post
     */
    Post getPostByAreaId(int areaId); //
}
