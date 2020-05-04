package com.daily.service.impl;

import com.daily.dao.UserDao;
import com.daily.dto.RegisterDTO;
import com.daily.dto.LoginDTO;
import com.daily.entity.User;
import com.daily.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public int login(LoginDTO loginDTO) {
        String truePassword = userDao.getPasswordByEmail(loginDTO.getEmail());
        if(truePassword==null) {
            return 2;//邮箱不存在
        }
        else if (loginDTO.getPassword().equals(truePassword))
            return 1;//密码正确
        return 3;//用户名或密码错误
    }

    @Override
    public int insertUser(RegisterDTO registerDTO) {

        //判断邮箱是否存在
        if(userDao.existEmail(registerDTO.getEmail())!=null)
            return 2;

        User user = new User();
        BeanUtils.copyProperties(registerDTO,user);
        //user.setUserDate(new Date());
        user.setState(1);
        user.setFansNum(0);
        user.setFollowNum(0);

        return userDao.insertUser(user);
    }

    @Override
    public int delUserById(int userId) {
        userDao.delUserById(userId);
        return 0;
    }

    @Override
    public int freezeUserById(int userId) {
        userDao.freezeUserById(userId);
        return 0;
    }
}
