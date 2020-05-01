package com.massizhi.daily.web;

import com.massizhi.daily.entity.UserExpand;
import com.massizhi.daily.entity.UserFollowInfo;
import com.massizhi.daily.service.UserFollowService;
import com.massizhi.daily.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserFollowController {
    @Autowired
    private UserFollowService userFollowService;
    /*
     * 根据用户ID得到用户关注的人的信息
     *
     * @param userId
     * @return Map<userFollowInfo, List<UserFollowInfo>>
     */
    @RequestMapping(value = "/getUserFollowInfoByUserId", method = RequestMethod.GET)
    private Map<String, Object> getUserFollowInfoByUserId(int userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<UserFollowInfo> userFollowInfoList=userFollowService.getUserFollowInfoByUserId(userId);
        modelMap.put("userFollowInfo", userFollowInfoList);
        return modelMap;
    }
}
