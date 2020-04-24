/**   
* @Title: PostServiceImpl.java 
* @Package com.daily.service.impl 
* @Description: TODO 
* @author Doris   
* @date 2020年4月5日 下午3:25:20 
* @version V1.0   
*/
package com.daily.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Post getPostByPostId(int postId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean addPost(Post post) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean modifyPost(Post post) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean deletePost(int postId) {
        // TODO Auto-generated method stub
        return false;
    }

}
