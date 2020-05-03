package com.massizhi.daily.web;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.massizhi.daily.entity.*;
import com.massizhi.daily.service.PostService;
import com.massizhi.daily.service.RecordService;
import com.massizhi.daily.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    private PostService postService;
    private RecordService recordService;

    /*
     * 通过用户ID得到用户信息
     * 提示：在这里将用户地区ID转化为地区名
     * @param userId
     * @return Map<userInfo,UserExpand>
     */
    @RequestMapping(value = "/getUserInfoByUserId", method = RequestMethod.GET)
    private Map<String, Object> getUserInfoByUserId(int userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        UserExpand userExpand = userService.getUserInfoByUserId(userId);
        modelMap.put("userInfo", userExpand);
        return modelMap;
    }

    /*
     * 修改用户信息
     *
     * @param user
     * @return Map<success,boolean>
     */
    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    private Map<String, Object> updateUserInfo(@RequestBody User user)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", userService.updateUserInfo(user));
        return modelMap;
    }

    /*
     * 根据用户ID得到用户帖子列表和动态列表
     *
     * @param userId
     * @return Map<userPostList, List<Post>>
     *         Map<userRecordList, List<Record>>
     */
    @RequestMapping(value = "/userPostListAndUserRecordList", method = RequestMethod.GET)
    private Map<String, Object> userPostListAndUserRecordList(int userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Post> userPostList=postService.getPostByUserId(userId);
        List<Record> userRecordList=recordService.getRecordListByUserId(userId);
        modelMap.put("userPostList", userPostList);
        modelMap.put("userRecordList", userRecordList);
        return modelMap;
    }

    /*
     * 根据用户ID和关键字搜索得到用户帖子列表和动态列表
     *
     * @param userId，keyWord
     * @return Map<userSelectedPostList, List<Post>>
     *         Map<userSelectedRecordList, List<Record>>
     */
    @RequestMapping(value = "/userSelectedPostAndRecordList", method = RequestMethod.GET)
    private Map<String, Object> userSelectedPostAndRecordList(int userId,String keyWord) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Post> userSelectedPostList=postService.getPostByContentAndUserId(keyWord,userId);
        List<Record> userSelectedRecordList=recordService.getRecordListByUserIdAndKeyWord(userId,keyWord);
        modelMap.put("userSelectedPostList", userSelectedPostList);
        modelMap.put("userSelectedRecordList", userSelectedRecordList);
        return modelMap;
    }

    /*
     * 取消关注，涉及到两个表tb_user和tb_user_follow
     *
     * @param userId,followId
     * @return boolean
     */
    @RequestMapping(value = "/cancelFollow", method = RequestMethod.GET)
    private Map<String, Object> cancelFollow(int userId,int followId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", userService.cancelFollow(userId,followId));
        return modelMap;
    }

    /*
     * 增加关注
     *
     * @param userId,followId
     * @return boolean
     */
    @RequestMapping(value = "/addFollow", method = RequestMethod.GET)
    private Map<String, Object> addFollow(int userId,int followId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", userService.addFollow(userId,followId));
        return modelMap;
    }

    /*
     * 增加关注，涉及到三个表tb_user和tb_user_follow和tb_post
     * ：通过用户ID和用户观看帖子的ID
     * @param userId,postId
     * @return boolean
     */
    @RequestMapping(value = "/addFollowByUserIdAndPostId", method = RequestMethod.GET)
    private Map<String, Object> addFollowByUserIdAndPostId(int userId,int postId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", userService.addFollowByUserIdAndPostId(userId,postId));
        return modelMap;
    }
}
