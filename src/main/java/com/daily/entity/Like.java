/**   
* @Title: Like.java 
* @Package com.daily.entity 
* @Description: TODO 
* @author Doris   
* @date 2020年4月28日 下午2:52:03 
* @version V1.0   
*/
package com.daily.entity;

/**
 * @ClassName: Like
 * @Description: TODO
 * @author Doris
 * @date 2020年4月28日 下午2:52:03
 * 
 */
public class Like {
    private Integer likeId;

    private Integer postId;

    private Integer userId;

    /**
     * @return the likeId
     */
    public Integer getLikeId() {
        return likeId;
    }

    /**
     * @param likeId the likeId to set
     */
    public void setLikeId(Integer likeId) {
        this.likeId = likeId;
    }

    /**
     * @return the postId
     */
    public Integer getPostId() {
        return postId;
    }

    /**
     * @param postId the postId to set
     */
    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    /**
     * @return the userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
