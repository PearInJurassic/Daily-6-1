package com.daily.service;

import com.daily.entity.UserFollowInfo;

import java.util.List;

public interface UserFollowService {
    /*
     * 根据用户ID得到用户关注的人的信息
     *
     * @param userId
     * @return List<UserFollowInfo>
     */
    List<UserFollowInfo> getUserFollowInfoByUserId(int userId);
    /*
     * 根据用户ID得到用户粉丝的信息
     *
     * @param userId
     * @return List<UserFollowInfo>
     */
    List<UserFollowInfo> getUserFansInfoByUserId(int userId);
    /*
     * 根据用户ID,关注ID查询是否存在关注
     *
     * @param userId,followId
     * @return int
     */
    boolean isExistFollow(int userId, int followId);
}
