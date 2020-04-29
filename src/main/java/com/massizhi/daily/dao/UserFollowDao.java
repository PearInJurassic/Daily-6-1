package com.massizhi.daily.dao;

import com.massizhi.daily.entity.UserFollow;

import java.util.List;

public interface UserFollowDao {
    /*
     * 根据用户ID得到关注列表
     *
     * @param userId
     * @return List<UserFollow>
     */
    List<UserFollow> getRecordListByAreaId(int userId);

    /*
     * 新增关注
     *
     * @param Comment
     * @return boolean
     */
    boolean createComment(Comment comment);
}
