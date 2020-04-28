package com.daily.service;

import com.daily.entity.Comment;

import java.util.List;

public interface CommentService {
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
     * 通过用户ID得到评论列表
     *
     * @param postId
     * @return List<Comment>
     */
    List<Comment> getCommentByUserId(int userId, int anonym);

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
