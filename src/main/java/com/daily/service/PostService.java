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
 * @date 2020年4月5日 下午2:44:19
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

    Post getPostByPostId(int postId);

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

}
