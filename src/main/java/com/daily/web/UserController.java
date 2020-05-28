package com.daily.web;

import com.daily.dto.LoginDTO;
import com.daily.dto.RegisterDTO;
import com.daily.entity.Post;
import com.daily.entity.RecordExpand;
import com.daily.entity.User;
import com.daily.entity.UserExpand;
import com.daily.service.PostService;
import com.daily.service.QiNiuService;
import com.daily.service.RecordService;
import com.daily.service.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;
    @Autowired
    private RecordService recordService;
    @Autowired
    private QiNiuService qiNiuService;

    /*
     * 登录
     * @param
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private Map<String, Object> checkLogin(@RequestBody LoginDTO loginDTO) {
        Map<String, Object> modelMap = new HashMap<String, Object>();;
        int result = userService.login(loginDTO);
        if (result == 1) {
            modelMap.put("code", 1);
            modelMap.put("message", "登录成功");
            Integer userId=userService.getUserIdByEmail(loginDTO.getEmail());
            modelMap.put("userId",userId);
        } else if (result == 2) {
            modelMap.put("code", 2);
            modelMap.put("message", "用户不存在");
        } else if (result == 3) {
            modelMap.put("code", 3);
            modelMap.put("message", "邮箱或密码输入错误");
        } else if (result == 4) {
            modelMap.put("code", 4);
            modelMap.put("message", "用户被冻结");
        }
        return modelMap;
    }

    /*
     * 注册
     * @param name password
     * @return Map<userInfo,UserExpand>
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    private Map<String, Object> register(@RequestBody RegisterDTO registerDTO) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        int result = userService.insertUser(registerDTO);
        if (result == 1) {
            modelMap.put("code", 1);
            modelMap.put("message", "注册成功");
        } else if (result == 2) {
            modelMap.put("code", 2);
            modelMap.put("message", "邮箱已经存在");
        }
        return modelMap;
    }

    /*
     * 冻结
     * @param
     * @return Map<userInfo,UserExpand>
     */
    @RequestMapping(value = "/freeze", method = RequestMethod.POST)
    private Map<String, Object> freeze(Integer userId) {
        int result = userService.freezeUserById(userId);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        if (result == 1) {
            modelMap.put("code", 1);
        } else {
            modelMap.put("code", 2);
        }
        return modelMap;
    }
    /*
    * 解冻
    * @param
    * @return Map<userInfo,UserExpand>
    * */
    @RequestMapping(value = "/unfreeze", method = RequestMethod.POST)
    private Map<String, Object> unfreeze(Integer userId){
        int result = userService.unfreezeUserById(userId);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        if(result == 1){
            modelMap.put("code", 1);
        }else{
            modelMap.put("code", 2);
        }
        return modelMap;
    }


    /*
     * 删除
     * @param
     * @return Map<userInfo,UserExpand>
     */
    @RequestMapping(value = "/deluser", method = RequestMethod.POST)
    private Map<String, Object> del(@RequestParam Integer userId) {
        int result = userService.delUserById(userId);
        Map<String, Object> modelMap = new HashMap<String, Object>();
        if (result == 1) {
            modelMap.put("code", 1);
            modelMap.put("message", "删除成功");
        } else {
            modelMap.put("code", 2);
            modelMap.put("message", "删除失败");
        }
        return modelMap;
    }

    /*
     * 通过用户ID得到用户信息
     * 提示：在这里地区名作为附加属性出现
     * @param userId
     * @return Map<userInfo,UserExpand>
     */
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    private Map<String, Object> getUserInfo(Integer userId) {
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
    private Map<String, Object> userPostAndRecordList(Integer userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Post> userPostList = postService.getPostByUserId(userId);
        List<RecordExpand> userRecordList = recordService.getRecordListByUserId(userId);
        modelMap.put("userPostList", userPostList);
        modelMap.put("userRecordList", userRecordList);
        return modelMap;
    }

    /*
     * 根据用户ID得到用户动态列表
     *
     * @param userId
     * @return Map<userRecordList, List<Record>>
     */
    @RequestMapping(value = "/userRecordList", method = RequestMethod.GET)
    private Map<String, Object> userRecordList(Integer userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<RecordExpand> userRecordList = recordService.getRecordListByUserId(userId);
        modelMap.put("userRecordList", userRecordList);
        return modelMap;
    }

    /*
     * 根据用户ID得到用户帖子列表
     *
     * @param userId
     * @return Map<userPostList, List<Post>>
     */
    @RequestMapping(value = "/userPostList", method = RequestMethod.GET)
    private Map<String, Object> userPostList(Integer userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Post> userPostList = postService.getPostByUserId(userId);
        modelMap.put("userPostList", userPostList);
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
    private Map<String, Object> userSelectedPostAndRecordList(Integer userId, String keyWord) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Post> userSelectedPostList = postService.getPostByContentAndUserId(keyWord, userId);
        List<RecordExpand> userSelectedRecordList = recordService.getRecordListByUserIdAndKeyWord(userId, keyWord);
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
    private Map<String, Object> cancelFollow(Integer userId, Integer followId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", userService.cancelFollow(userId, followId));
        return modelMap;
    }

    /*
     * 增加关注
     *
     * @param userId,followId
     * @return boolean
     */
    @RequestMapping(value = "/addFollow", method = RequestMethod.GET)
    private Map<String, Object> addFollow(Integer userId, Integer followId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", userService.addFollow(userId, followId));
        return modelMap;
    }

    /*
     * 增加关注，涉及到三个表tb_user和tb_user_follow和tb_post
     * ：通过用户ID和用户观看帖子的ID
     * @param userId,postId
     * @return boolean
     */
    @RequestMapping(value = "/addFollowByUserIdAndPostId", method = RequestMethod.GET)
    private Map<String, Object> addFollowByUserIdAndPostId(Integer userId, Integer postId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("success", userService.addFollowByUserIdAndPostId(userId, postId));
        return modelMap;
    }

    /*
     * 得到邮箱验证码
     *
     * @param email
     * @return int
     */
    @RequestMapping(value = "/getVerificationCode", method = RequestMethod.GET)
    private Map<String, Object> getVerificationCode(String emailCode) throws EmailException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        //生成6位数字随机数
        Random r = new Random();
        int random=r.nextInt(899999)+100000;

        HtmlEmail email=new HtmlEmail();//创建一个HtmlEmail实例对象
        email.setHostName("smtp.163.com");//邮箱的SMTP服务器，一般123邮箱的是smtp.123.com,qq邮箱为smtp.qq.com,163...
        email.setCharset("utf-8");//设置发送的字符类型

        email.addTo(emailCode);//设置收件人
        email.setFrom("mkxfzu@163.com","Daily 账户团队");//发送人的邮箱为自己的，用户名可以随便填

        //设置发送人到的邮箱和用户名和授权码(授权码是自己设置的)
        email.setAuthentication("mkxfzu@163.com","LTMCDVCBUSFTCIYM");

        email.setSubject("Daily 账户安全验证码");//设置发送主题
        email.setMsg("Daily 账户安全验证码\n请为您的账户"+emailCode+"" +
                "使用以下验证码。\n验证码："+random+"\n\n谢谢！\nDaily 账户团队");//设置发送内容
        email.send();//进行发送
        modelMap.put("verificationCode", random);
        return modelMap;
    }
}
