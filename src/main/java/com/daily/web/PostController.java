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
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController

public class PostController {
    @Autowired
    private PostService postService;

    /**
     * 获取所有的帖子信息
     * 
     * @return
     */
    @RequestMapping(value = "/listpost", method = RequestMethod.GET)
    private Map<String, Object> listPost() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Post> list = new ArrayList<Post>();

        list = postService.getPostList();
        modelMap.put("areaList", list);
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
        modelMap.put("post", post);
        return modelMap;
    }

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
    private Map<String, Object> addArea(@RequestBody Post post)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 添加区域信息
        modelMap.put("success", postService.addPost(post));
        return modelMap;
    }

    /**
     * 修改区域信息，主要修改名字
     *
     * @param areaStr
     * @param request
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/modifypost", method = RequestMethod.POST)
    private Map<String, Object> modifyArea(@RequestBody Post post)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        modelMap.put("success", postService.modifyPost(post));
        return modelMap;
    }

    @RequestMapping(value = "/removepost", method = RequestMethod.GET)
    private Map<String, Object> removeArea(Integer postId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        modelMap.put("success", postService.deletePost(postId));
        return modelMap;
    }

    @RequestMapping(value = "/forwardpost", method = RequestMethod.GET)
    private Map<String, Object> forwardPost(int postId, int userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        // modelMap.put("areaList", list);
        return modelMap;
    }

}
