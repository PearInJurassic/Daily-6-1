/**   
* @Title: LikeController.java 
* @Package com.daily.web 
* @Description: TODO 
* @author Doris   
* @date 2020年4月28日 下午4:03:47 
* @version V1.0   
*/
package com.daily.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daily.entity.Like;
import com.daily.service.LikeService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * @ClassName: LikeController
 * @Description: TODO
 * @author Doris
 * @date 2020年4月28日 下午4:03:47
 * 
 */
@RestController
public class LikeController {
    @Autowired
    private LikeService likeService;

    /**
     * 获取所有的帖子信息
     * 
     * @return
     */
    @RequestMapping(value = "/getlikenum", method = RequestMethod.GET)
    private Map<String, Object> getLikeNum(Integer postId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        int num = likeService.getLikeNumByPostId(postId);
        modelMap.put("likeNum", num);
        return modelMap;
    }

    @RequestMapping(value = "/islike", method = RequestMethod.GET)
    private Map<String, Object> isLike(Integer postId, Integer userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        int num = likeService.getLikeByPostIdAndUserId(postId, userId);
        if (num == 0) {
            modelMap.put("like", false);
        } else {
            modelMap.put("like", true);
        }

        return modelMap;
    }

    @RequestMapping(value = "/addlike", method = RequestMethod.POST)
    private Map<String, Object> addLike(@RequestBody Like like)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        modelMap.put("success", likeService.addLike(like));
        return modelMap;
    }

    @RequestMapping(value = "/removelike", method = RequestMethod.GET)
    private Map<String, Object> removeLike(Integer postId, Integer userId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();

        modelMap.put("success", likeService.deleteLike(postId, userId));
        return modelMap;
    }

}
