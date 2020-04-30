/**   
* @Title: PostServiceImpl.java 
* @Package com.daily.service.impl 
* @Description: TODO 
* @author Doris   
* @date 2020年4月5日 下午3:25:20 
* @version V1.0   
*/
package com.daily.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.daily.dao.PostDao;
import com.daily.entity.Post;
import com.daily.service.PostService;

/**
 * @ClassName: PostServiceImpl
 * @Description: TODO
 * @author Doris
 * @date 2020年4月5日 下午3:25:20
 * 
 */
@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostDao postDao;

    @Override
    public List<Post> getPostList() {
        return postDao.queryPost();
    }

    @Override
    public List<Post> getPostByUserId(int userId) {

        return postDao.queryPostByUserId(userId);
    }

    @Override
    public Post getPostByPostId(int postId) {

        return postDao.queryPostByPostId(postId);
    }

    @Override
    @Transactional
    public boolean addPost(Post post) {

        if (post.getPostContent() != null && !"".equals(post.getPostContent())) {
            // 设置默认值
            post.setPostCreateTime(new Date());
            post.setPostUpdateTime(new Date());
            try {
                int effectedNum = postDao.insertPost(post);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("添加帖子信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("添加帖子信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("帖子内容不能为空！");
        }
    }

    @Override
    @Transactional
    public boolean modifyPost(Post post) {

        if (post.getPostId() != null && post.getPostId() > 0) {
            // 设置默认值
            post.setPostUpdateTime(new Date());
            try {
                // 更新区域信息
                int effectedNum = postDao.updatePost(post);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新帖子信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新帖子信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("帖子信息不能为空！");
        }
    }

    @Override
    @Transactional
    public boolean deletePost(int postId) {
        if (postId > 0) {
            try {
                // 删除区域信息
                int effectedNum = postDao.deletePost(postId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除帖子信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除帖子信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("无法找到对应的帖子！");
        }
    }

    @Override
    @Transactional
    public boolean likePost(int postId) {
        // TODO Auto-generated method stub
        return postDao.incLikeNum(postId) == 1 ? true : false;
    }

    @Override
    @Transactional
    public boolean unlikePost(int postId) {
        // TODO Auto-generated method stub
        return postDao.decLikeNum(postId) == 1 ? true : false;
    }

    @Override
    @Transactional
    public boolean forwardPost(int postId) {
        // TODO Auto-generated method stub
        return postDao.incForwardNum(postId) == 1 ? true : false;
    }

    @Override
    @Transactional
    public boolean commentPost(int postId) {
        // TODO Auto-generated method stub
        return postDao.incCommentNum(postId) == 1 ? true : false;
    }

    @Override
    @Transactional
    public boolean uncommentPost(int postId) {
        // TODO Auto-generated method stub
        return postDao.incCommentNum(postId) == 1 ? true : false;
    }

    @Override
    @Transactional
    public boolean tipoffPost(int postId) {
        // TODO Auto-generated method stub
        return postDao.incTipoffNum(postId) == 1 ? true : false;
    }

    @Override
    @Transactional
    public boolean untipoffPost(int postId) {
        // TODO Auto-generated method stub
        return postDao.incTipoffNum(postId) == 1 ? true : false;
    }

    @Override
    public List<Post> getRequireAuditPost() {
        // TODO Auto-generated method stub
        return postDao.queryRequireAuditPost();
    }

    @Override
    public List<Post> getPostByContent(String str) {
        // TODO Auto-generated method stub
        return postDao.queryPostByContent(str);
    }

    @Override
    public List<Post> getPostByContentAndUserId(String str, int userId) {
        // TODO Auto-generated method stub
        return postDao.queryPostByContentAndUserId(str, userId);
    }

}
