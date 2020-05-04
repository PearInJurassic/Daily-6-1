package com.daily.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daily.entity.Post;
import com.daily.service.PostService;
import com.daily.service.TagService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController

public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private TagService tagService;

    /**
     * 广场上获取所有的帖子信息
     * 
     * @return
     */
    @RequestMapping(value = "/listpost", method = RequestMethod.GET)
    private Map<String, Object> listPost() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Post> postList = new ArrayList<Post>();

        Map<Integer, List<String>> postTagMap = new HashMap<>();

        postList = postService.getPostList();
        for (Post post : postList) {
            List<String> tagString = tagService.getTagByPostId(post.getPostId());
            postTagMap.put(post.getPostId(), tagString);
        }
        modelMap.put("postList", postList);
        modelMap.put("tagMap", postTagMap);
        return modelMap;
    }

    /**
     * 通过Id获取帖子信息
     *
     * @return
     */
    @RequestMapping(value = "/getpostbypostid", method = RequestMethod.GET)
    private Map<String, Object> getAreaById(Integer postId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        Post post = postService.getPostByPostId(postId);
        // 显示一个帖子的所有评论
        // CommentService.
        modelMap.put("post", post);
        return modelMap;
    }

    /**
     * 获取待审核帖子
     *
     * @return
     */
    @RequestMapping(value = "/getrequireauditpost", method = RequestMethod.GET)
    private Map<String, Object> getRequireAuditPost() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Post> list = new ArrayList<Post>();
        list = postService.getRequireAuditPost();
        modelMap.put("postList", list);
        return modelMap;
    }

    @RequestMapping(value = "/searchpostbycontent", method = RequestMethod.GET)
    private Map<String, Object> searchPostByContent(String str) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Post> list = new ArrayList<Post>();
        list = postService.getPostByContent(str);
        modelMap.put("postList", list);
        return modelMap;
    }

    @RequestMapping(value = "/searchareabycontent", method = RequestMethod.GET)
    private Map<String, Object> searchAreaByContent(String str) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Integer> list = new ArrayList<Integer>();
        list = postService.getAreaByContent(str);
        modelMap.put("postList", list);
        return modelMap;
    }

    @RequestMapping(value = "/searchpostbycontentanduserid", method = RequestMethod.GET)
    private Map<String, Object> searchPostByContentAndUserId(String str, Integer userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Post> list = new ArrayList<Post>();
        list = postService.getPostByContentAndUserId(str, userId);
        modelMap.put("postList", list);
        return modelMap;
    }

    /**
     * 添加区域信息
     *
     * @param areaStr
     * @param request
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/addpost", method = RequestMethod.POST)
    private Map<String, Object> addPost(@RequestBody Post post)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        modelMap.put("success", postService.addPost(post));
        Post newPost = postService.getLastPost();
        modelMap.put("newPost", newPost);
        return modelMap;
    }

    @RequestMapping(value = "/modifypost", method = RequestMethod.POST)
    private Map<String, Object> modifyArea(@RequestBody Post post)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        modelMap.put("success", postService.modifyPost(post));
        Post modifiedpost = postService.getPostByPostId(post.getPostId());
        modelMap.put("post", modifiedpost);
        return modelMap;
    }

    @RequestMapping(value = "/removepost", method = RequestMethod.GET)
    private Map<String, Object> removeArea(Integer postId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        modelMap.put("success", postService.deletePost(postId));
        List<Post> postList = new ArrayList<Post>();
        postList = postService.getPostList();
        modelMap.put("postList", postList);
        return modelMap;
    }

    @RequestMapping(value = "/forwardpost", method = RequestMethod.GET)
    private Map<String, Object> forwardPost(int postId, int userId, String str) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int newPostId = postService.forwardPost(postId, userId, str);
        Post forwardpost = postService.getPostByPostId(newPostId);
        modelMap.put("post", forwardpost);
        return modelMap;
    }

    @RequestMapping(value = "/tipoffpost", method = RequestMethod.GET)
    private Map<String, Object> tipoffPost(int postId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        modelMap.put("success", postService.tipoffPost(postId));
        return modelMap;
    }

}
