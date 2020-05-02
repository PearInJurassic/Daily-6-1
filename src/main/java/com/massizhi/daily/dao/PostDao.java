package com.massizhi.daily.dao;

import com.massizhi.daily.entity.Post;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PostDao {
    /**
     * 根据UserId找出该用户的所有帖子
     *
     * @return postList
     */
    List<Post> queryPostByUserId(int UserId);

    /**
     * 搜索某一用户的帖子
     *
     * @return userId
     */
    List<Post> queryPostByContentAndUserId(@Param("str") String str, @Param("userId") int userId);
}
