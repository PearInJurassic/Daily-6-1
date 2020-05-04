package com.daily.service;
import com.daily.dto.RegisterDTO;
import com.daily.dto.LoginDTO;
public interface UserService {
    int login(LoginDTO loginDTO);

    int insertUser(RegisterDTO registerDTO);

    int delUserById(int userId);

    int freezeUserById(int userId);
}
