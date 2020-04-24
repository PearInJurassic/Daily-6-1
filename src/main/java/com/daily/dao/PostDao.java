/**   
* @Title: PostDao.java 
* @Package com.daily.dao 
* @Description: TODO 
* @author Doris   
* @date 2020年4月5日 上午11:40:13 
* @version V1.0   
*/
package com.daily.dao;

import java.util.List;

import com.daily.entity.Post;

/**
 * @ClassName: PostDao
 * @Description: TODO
 * @author Doris
 * @date 2020年4月5日 上午11:40:13
 * 
 */
public interface PostDao {
    /**
     * 查询所有帖子
     * 
     * @return postList
     */
    List<Post> queryPost();

    /**
     * 根据UserId找出该用户的所有帖子
     * 
     * @return postList
     */
    List<Post> queryPostByUserId(int UserId);

    /**
     * 根据postId找出userId
     * 
     * @return userId
     */
    int queryUserByPostId(int postId);

    /**
     * 增加帖子
     * 
     * @param area
     * @param anonym
     * @return
     */
    int insertPost(Post post);

    /**
     * 修改帖子
     * 
     * @param post
     * @return
     */
    int updatePost(Post post);

    /**
     * 删除帖子
     * 
     * @param postId
     * @return
     */
    int deleteArea(int postId);

    /**
     * 更新评论数
     * 
     * @param postId
     * @return
     */
    int updateCommentNum(int postId);

    /**
     * 查询评论数
     * 
     * @param postId
     * @return
     */
    int queryCommentNum(int postId);

    /**
     * 更新点赞数
     * 
     * @param postId
     * @return
     */
    int updateLikeNum(int postId);

    /**
     * 查询点赞数
     * 
     * @param postId
     * @return
     */
    int queryLikeNum(int postId);

}
