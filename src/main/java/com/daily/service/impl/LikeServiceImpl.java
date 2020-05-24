/**   
* @Title: LikeServiceImpl.java 
* @Package com.daily.service.impl 
* @Description: TODO 
* @author Doris   
* @date 2020年4月28日 下午3:47:03 
* @version V1.0   
*/
package com.daily.service.impl;

import com.daily.dao.LikeDao;
import com.daily.entity.Like;
import com.daily.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: LikeServiceImpl
 * @Description: TODO
 * @author Doris
 * @date 2020年4月28日 下午3:47:03
 * 
 */
@Service
public class LikeServiceImpl implements LikeService {
    @Autowired
    private LikeDao likeDao;

    @Override
    public int getLikeNumByPostId(int postId) {

        return likeDao.queryLikeNumByPostId(postId);
    }

    @Override
    public boolean addLike(Like like) {
        if (like.getPostId() != null && like.getUserId() != null) {

            try {
                int effectedNum = likeDao.insertLike(like);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("添加点赞信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加点赞信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("被点赞的帖子id和用户id不能为空！");
        }
    }

    @Override
    public boolean deleteLike(int postId, int userId) {
        if (postId > 0 && userId > 0) {
            try {
                // 删除区域信息
                int effectedNum = likeDao.deleteLike(postId, userId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除点赞信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除点赞信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("无法找到对应的点赞信息！");
        }
    }

    @Override
    public int getLikeByPostIdAndUserId(int postId, int userId) {

        return likeDao.queryLikeByPostIdAndUserId(postId, userId);
    }

}
