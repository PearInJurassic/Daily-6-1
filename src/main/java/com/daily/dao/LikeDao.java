/**   
* @Title: LikeDao.java 
* @Package com.daily.dao 
* @Description: TODO 
* @author Doris   
* @date 2020年4月28日 下午3:06:48 
* @version V1.0   
*/
package com.daily.dao;

import com.daily.entity.Like;

/**
 * @ClassName: LikeDao
 * @Description: TODO
 * @author Doris
 * @date 2020年4月28日 下午3:06:48
 * 
 */
public interface LikeDao {

    int queryLikeNumByPostId(int postId);

    int queryLikeByPostIdAndUserId(int postId, int userId);

    int insertLike(Like like);

    int deleteLike(int postId, int userId);

}