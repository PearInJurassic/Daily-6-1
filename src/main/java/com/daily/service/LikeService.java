/**   
* @Title: LikeService.java 
* @Package com.daily.service 
* @Description: TODO 
* @author Doris   
* @date 2020年4月28日 下午3:16:20 
* @version V1.0   
*/
package com.daily.service;

import com.daily.entity.Like;

/**
 * @ClassName: LikeService
 * @Description: TODO
 * @author Doris
 * @date 2020年4月28日 下午3:16:20
 * 
 */
public interface LikeService {
    int getLikeNumByPostId(int postId);

    boolean addLike(Like like);

    boolean deleteLike(int postId, int userId);
}