package com.massizhi.daily.entity;

public class Tag {
    //标签ID
    private Integer tagId;
    //标签内容
    private String tagContent;
    //标签对应的帖子ID
    private Integer postId;

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagContent() {
        return tagContent;
    }

    public void setTagContent(String tagContent) {
        this.tagContent = tagContent;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }
}
