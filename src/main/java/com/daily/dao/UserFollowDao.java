package com.daily.dao;

import com.daily.entity.UserFollow;

import java.util.List;

public interface UserFollowDao {
    /*
     * 根据用户ID得到关注列表(只需要对方id)
     *
     * @param userId
     * @return List<Integer>
     */
    List<Integer> getUserFollowIDListByUserId(int userId);
    /*
     * 根据用户ID,关注ID得到关注
     *
     * @param userId,followId
     * @return UserFollow
     */
    UserFollow getUserFollowByTwoId(int userId, int followId);
    /*
     * 新增关注
     *
     * @param userFollow
     * @return int
     */
    int insertUserFollow(UserFollow userFollow);
    /*
     * 删除关注通过用户ID,关注ID
     *
     * @param userFollow
     * @return int
     */
    int deleteUserFollowByTwoId(int userId, int followId);
}
