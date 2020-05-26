package com.daily.web;

import com.daily.entity.UserFollowInfo;
import com.daily.service.UserFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserFollowController {
    @Autowired
    private UserFollowService userFollowService;
    /*
     * 根据用户ID得到用户关注的人的信息(展示关注列表功能及点击关注跳转功能)
     *
     * @param userId
     * @return Map<userFollowInfo, List<UserFollowInfo>>
     */
    @RequestMapping(value = "/getUserFollowInfo", method = RequestMethod.GET)
    private Map<String, Object> getUserFollowInfo(Integer userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<UserFollowInfo> userFollowInfoList=userFollowService.getUserFollowInfoByUserId(userId);
        modelMap.put("userFollowInfo", userFollowInfoList);
        return modelMap;
    }
}
