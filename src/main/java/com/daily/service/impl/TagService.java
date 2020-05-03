/**   
* @Title: TagService.java 
* @Package com.daily.service 
* @Description: TODO 
* @author Doris   
* @date 2020年5月3日 
* @version V1.0   
*/
package com.daily.service;

import java.util.List;

import com.daily.entity.Tag;

/**
 * @ClassName: TagService
 * @Description: TODO
 * @author Doris
 * @date 2020年5月3日
 * 
 */
public interface TagService {
    boolean addTag(Tag tag);

    boolean deleteTag(int tagId);

    List<String> getTagByPostId(int postId);
}
