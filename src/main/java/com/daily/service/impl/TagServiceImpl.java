/**   
* @Title: TagServiceImpl.java 
* @Package com.daily.service.impl 
* @Description: TODO 
* @author Doris   
* @date 2020年5月3日 
* @version V1.0   
*/
package com.daily.service.impl;

import com.daily.dao.TagDao;
import com.daily.entity.Tag;
import com.daily.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: TagServiceImpl
 * @Description: TODO
 * @author Doris
 * @date 2020年5月3日
 * 
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagDao tagDao;

    @Override
    public Integer addTag(Tag tag) {
        // 空值判断，主要是判断areaName不为空
        if (tag.getTagContent() != null && !"".equals(tag.getTagContent())) {
            // 设置默认值

            try {
                tagDao.insertTag(tag);
                Integer effectedNum = tag.getTagId();
                if (effectedNum != null) {
                    return effectedNum.intValue();
                } else {
                    throw new RuntimeException("添加标签信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加标签信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("标签信息不能为空！");
        }
    }

    @Override
    public boolean deleteTag(int tagId) {
        if (tagId > 0) {
            try {
                // 删除区域信息
                int effectedNum = tagDao.deleteTag(tagId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除标签信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除标签信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("标签Id不能为空！");
        }
    }

    @Override
    public List<Tag> getTagByPostId(int postId) {
        // TODO Auto-generated method stub
        return tagDao.queryTagByPostId(postId);
    }

}
