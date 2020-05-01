package com.massizhi.daily.service;

import com.massizhi.daily.entity.UserFollow;
import com.massizhi.daily.entity.UserFollowInfo;

import java.util.List;

public interface UserFollowService {
    /*
     * 根据用户ID得到用户关注的人的信息
     *
     * @param userId
     * @return List<UserFollowInfo>
     */
    List<UserFollowInfo> getUserFollowInfoByUserId(int userId);
}
