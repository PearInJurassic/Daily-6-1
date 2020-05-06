/**   
* @Title: TagService.java 
* @Package com.daily.service 
* @Description: TODO 
* @author Doris   
* @date 2020年5月3日 
* @version V1.0   
*/
package com.daily.service;

import com.daily.entity.Tag;

import java.util.List;

/**
 * @ClassName: TagService
 * @Description: TODO
 * @author Doris
 * @date 2020年5月3日
 * 
 */
public interface TagService {
    Integer addTag(Tag tag);

    boolean deleteTag(int tagId);

    List<Tag> getTagByPostId(int postId);
}
