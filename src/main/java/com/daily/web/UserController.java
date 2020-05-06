package com.daily.web;

import com.daily.dto.LoginDTO;
import com.daily.dto.RegisterDTO;
import com.daily.entity.Post;
import com.daily.entity.RecordExpand;
import com.daily.entity.User;
import com.daily.entity.UserExpand;
import com.daily.service.PostService;
import com.daily.service.RecordService;
import com.daily.service.UserService;
import com.daily.vo.UserInfoVO;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    private PostService postService;
    private RecordService recordService;

    /*
     * 登录
     * @param
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private Map<String, Object> checkLogin(@RequestBody LoginDTO loginDTO, HttpServletRequest request)
            throws JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        HttpSession session = request.getSession();
        int result = userService.login(loginDTO,session);
        if(result==1){
            int userId = Integer.parseInt(session.getAttribute("userId").toString());
            UserInfoVO userInfoVO=userService.getUserInfoById(userId);
            modelMap.put("code",1);
            modelMap.put("message","登录成功");
            modelMap.put("userInfo",userInfoVO);
        }
        else if(result==2){
            modelMap.put("code",2);
            modelMap.put("message","邮箱不存在");
        }
        else if(result==3){
            modelMap.put("code",3);
            modelMap.put("message","邮箱或密码输入错误");
        }
        return modelMap;
    }

    @RequestMapping(value = "/userinfo", method = RequestMethod.GET)
    private Map<String, Object> getUserInfo( HttpServletRequest request)
            throws JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        HttpSession session = request.getSession();
        int userId=Integer.parseInt(session.getAttribute("userId").toString());
        //UserInfoVO userInfoVO=userService.getUserInfoById(userId);
        UserExpand userExpand=userService.getUserInfoByUserId(userId);
        modelMap.put("code",1);
        modelMap.put("message","获取成功");
        //modelMap.put("userInfo",userInfoVO);
        modelMap.put("userInfo",userExpand);

        return modelMap;
    }

    /*
     * 登出
     *
     * @return Map<userInfo,UserExpand>
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    private Map<String, Object> checkLogin(HttpServletRequest request)
            throws JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        HttpSession session = request.getSession();
        session.invalidate();
        modelMap.put("code",1);
        modelMap.put("message","登出成功");
        return modelMap;
    }

    /*
     * 注册
     * @param name password
     * @return Map<userInfo,UserExpand>
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    int register(@RequestBody RegisterDTO registerDTO)
            throws JsonMappingException, IOException {
        System.out.println(registerDTO.toString());
        return userService.insertUser(registerDTO);
    }

    /*
     * 冻结
     * @param name password
     * @return Map<userInfo,UserExpand>
     */
    @RequestMapping(value = "/freeze", method = RequestMethod.POST)
    int freeze(@RequestParam Map<String, Object> params)
            throws JsonMappingException, IOException {
        userService.freezeUserById(Integer.parseInt(params.get("userId").toString()));
        return 0;
    }

    /*
     * 删除
     * @param name password
     * @return Map<userInfo,UserExpand>
     */
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    int del(@RequestParam Map<String, Object> params)
            throws JsonMappingException, IOException {
        userService.delUserById(Integer.parseInt(params.get("userId").toString()));
        return 0;
    }

    /*
     * 通过用户ID得到用户信息
     * 提示：在这里地区名作为附加属性出现
     * @param userId
     * @return Map<userInfo,UserExpand>
     */
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    private Map<String, Object> getUserInfo(int userId) {
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
    @RequestMapping(value = "/userPostAndRecordList", method = RequestMethod.GET)
    private Map<String, Object> userPostAndRecordList(int userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Post> userPostList=postService.getPostByUserId(userId);
        List<RecordExpand> userRecordList=recordService.getRecordListByUserId(userId);
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
        List<RecordExpand> userSelectedRecordList=recordService.getRecordListByUserIdAndKeyWord(userId,keyWord);
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
