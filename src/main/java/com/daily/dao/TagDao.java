
package com.daily.dao;

import java.util.List;

import com.daily.entity.Tag;

public interface TagDao {
    List<Tag> queryTagByPostId(int postId);

    int insertTag(Tag tag);

    int deleteTag(int tagId);

}
