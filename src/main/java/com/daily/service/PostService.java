/**   
* @Title: PostService.java 
* @Package com.daily.service 
* @Description: TODO 
* @author Doris   
* @date 2020年4月5日 下午2:44:19 
* @version V1.0   
*/
package com.daily.service;

import java.util.List;

import com.daily.entity.Post;

/**
 * @ClassName: PostService
 * @Description: TODO
 * @author Doris
 * @date 2020年4月27日 下午2:44:19
 * 
 */
public interface PostService {
    /**
     * 获取所有帖子列表
     * 
     * @return
     */
    List<Post> getPostList();

    /**
     * 通过发帖人Id获取帖子信息
     * 
     * @param areaId
     * @return
     */
    List<Post> getPostByUserId(int userId);

    /**
     * 获取特定的帖子
     * 
     * @return
     */
    Post getPostByPostId(int postId);

    List<Post> getRequireAuditPost();

    List<Post> getPostByContent(String str);

    List<Post> getPostByContentAndUserId(String str, int userId);

    List<Integer> getAreaByContent(String str);

    Post getLastPost();

    /**
     * 增加帖子信息
     * 
     * @param area
     * @return
     */
    boolean addPost(Post post);

    /**
     * 修改帖子信息
     * 
     * @param area
     * @return
     */
    boolean modifyPost(Post post);

    /**
     * 删除帖子信息
     * 
     * @param area
     * @return
     */
    boolean deletePost(int postId);

    boolean likePost(int postId);

    boolean unlikePost(int postId);

    boolean forwardPost(int postId);

    boolean commentPost(int postId);

    boolean uncommentPost(int postId);

    boolean tipoffPost(int postId);

    boolean untipoffPost(int postId);

    int forwardPost(int postId, int userId, String str);

}
