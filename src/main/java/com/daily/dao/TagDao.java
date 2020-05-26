
package com.daily.dao;

import com.daily.entity.Tag;

import java.util.List;

public interface TagDao {
    List<Tag> queryTagByPostId(int postId);

    int insertTag(Tag tag);

    int deleteTag(int tagId);

}
