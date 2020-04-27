package com.daily.dao;

import com.daily.entity.Comment;

import java.util.List;

public interface CommentDao {
    /*
     * 通过评论ID得到评论信息
     *
     * @param commentId
     * @return Comment
     */
    Comment getCommentByCommentId(int commentId);

    /*
     * 通过帖子ID得到评论列表
     *
     * @param postId
     * @return List<Comment>
     */
    List<Comment> getCommentByPostId(int postId);

    /*
     * 新增评论
     *
     * @param Comment
     * @return boolean
     */
    boolean createComment(Comment comment);

    /*
     * 修改评论
     *
     * @param Comment
     * @return boolean
     */
    boolean updateComment(Comment comment);

    /*
     * 删除评论
     *
     * @param commentId
     * @return boolean
     */
    boolean deleteComment(int commentId);
}
