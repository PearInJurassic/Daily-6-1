package com.daily.web;

import com.daily.dto.LoginDTO;
import com.daily.dto.RegisterDTO;
import com.daily.service.UserService;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /*
     * 登录
     * @param
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    int checkLogin(@RequestBody LoginDTO loginDTO, HttpServletRequest request)
            throws JsonMappingException, IOException {
        int result = userService.login(loginDTO);
        if (result == 1) {
            HttpSession session = request.getSession();
            session.setAttribute("user", loginDTO.getPassword());
        }
        return result;
    }

    /*
     * 登出
     *
     * @return Map<userInfo,UserExpand>
     */
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    int checkLogin(HttpServletRequest request)
            throws JsonMappingException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        return 0;
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
}
