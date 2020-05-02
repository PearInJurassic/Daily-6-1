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

import org.apache.ibatis.annotations.Param;

import com.daily.entity.Post;

/**
 * @ClassName: PostDao
 * @Description: TODO
 * @author Doris
 * @date 2020年4月27日 上午11:40:13
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

    List<Post> queryRequireAuditPost();

    /**
     * 搜索帖子
     * 
     * @return userId
     */
    List<Post> queryPostByContent(@Param("str") String str);

    /**
     * 搜索某一用户的帖子
     * 
     * @return userId
     */
    List<Post> queryPostByContentAndUserId(String str, int userId);

    /**
     * 搜索某一用户的帖子
     * 
     * @return userId
     */
    List<Integer> queryAreaByContent(@Param("str") String str);

    /**
     * 根据postId找出帖子
     * 
     * @return userId
     */
    Post queryPostByPostId(int postId);

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
    int deletePost(int postId);

    /**
     * 增加评论数
     * 
     * @param postId
     * @return
     */
    int incCommentNum(int postId);

    /**
     * 减少评论数
     * 
     * @param postId
     * @return
     */
    int decCommentNum(int postId);

    /**
     * 查询评论数
     * 
     * @param postId
     * @return
     */
    int queryCommentNum(int postId);

    /**
     * 增加点赞数
     * 
     * @param postId
     * @return
     */
    int incLikeNum(int postId);

    /**
     * 减少点赞数
     * 
     * @param postId
     * @return
     */
    int decLikeNum(int postId);

    /**
     * 查询点赞数
     * 
     * @param postId
     * @return
     */
    int queryLikeNum(int postId);

    /**
     * 增加举报数
     * 
     * @param postId
     * @return
     */
    int incTipoffNum(int postId);

    /**
     * 减少举报数
     * 
     * @param postId
     * @return
     */
    int decTipoffNum(int postId);

    /**
     * 查询点赞数
     * 
     * @param postId
     * @return
     */
    int queryTipoffNum(int postId);

    /**
     * 增加举报数
     * 
     * @param postId
     * @return
     */
    int incForwardNum(int postId);

    /**
     * 减少举报数
     * 
     * @param postId
     * @return
     */
    int decForwardNum(int postId);

    /**
     * 查询点赞数
     * 
     * @param postId
     * @return
     */
    int queryForwardNum(int postId);

}
