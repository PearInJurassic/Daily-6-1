package com.daily.web;

import com.daily.entity.Tag;
import com.daily.service.TagService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TagController {
    @Autowired
    private TagService tagService;

    /**
     * 获取所有的一个帖子所有标签信息
     * 
     * @return
     */
    @RequestMapping(value = "/listtag", method = RequestMethod.GET)
    private Map<String, Object> listTag(Integer postId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Tag> list = new ArrayList<Tag>();

        list = tagService.getTagByPostId(postId);
        modelMap.put("tagList", list);
        return modelMap;
    }

    /**
     * 
     * 
     * @param areaStr
     * @param request
     * @return
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    @RequestMapping(value = "/addtag", method = RequestMethod.POST)
    private Map<String, Object> addTag(@RequestBody Tag tag)
            throws JsonParseException, JsonMappingException, IOException {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 添加区域信息
        modelMap.put("success", tagService.addTag(tag));
        return modelMap;
    }

    @RequestMapping(value = "/removetag", method = RequestMethod.GET)
    private Map<String, Object> removeTag(Integer tagId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        // 修改区域信息
        modelMap.put("success", tagService.deleteTag(tagId));
        return modelMap;
    }

}
