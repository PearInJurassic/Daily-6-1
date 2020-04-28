package com.massizhi.daily.entity;

public class Tag {
    //标签ID
    private int tagId;
    //标签内容
    private String tagContent;
    //标签对应的帖子ID
    private int postId;

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getTagContent() {
        return tagContent;
    }

    public void setTagContent(String tagContent) {
        this.tagContent = tagContent;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
