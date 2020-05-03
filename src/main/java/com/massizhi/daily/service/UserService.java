package com.massizhi.daily.service;

import com.massizhi.daily.entity.User;
import com.massizhi.daily.entity.UserExpand;

public interface UserService {
    /*
     * 通过用户ID得到用户信息
     * 提示：在这里将用户地区ID转化为地区名
     * @param userId
     * @return User
     */
    UserExpand getUserInfoByUserId(int userId);
    /*
     * 修改用户信息
     *
     * @param user
     * @return boolean
     */
    boolean updateUserInfo(User user);
    /*
     * 取消关注，涉及到两个表tb_user和tb_user_follow
     *
     * @param userId,followId
     * @return boolean
     */
    boolean cancelFollow(int userId,int followId);
    /*
     * 增加关注，涉及到两个表tb_user和tb_user_follow
     * ：通过用户ID和所要关注的人的ID
     * @param userId,followId
     * @return boolean
     */
    boolean addFollow(int userId,int followId);
    /*
     * 增加关注，涉及到三个表tb_user和tb_user_follow和tb_post
     * ：通过用户ID和用户观看帖子的ID
     * @param userId,postId
     * @return boolean
     */
    boolean addFollowByUserIdAndPostId(int userId,int postId);
}
