package com.daily.service;


import static org.junit.Assert.assertEquals;

import com.daily.dto.RegisterDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest

public class UserServiceTest {
    @Autowired
    private UserService userService;
    private RegisterDTO registerDTO =new RegisterDTO();

    @Test
    public void testInsertUser() {
        registerDTO.setUserType(0);
        registerDTO.setEmail("2demail@example.com");
        registerDTO.setUserName("terrorist");
        registerDTO.setUserPwd("733608");

        
        int i=userService.insertUser(registerDTO);
        assertEquals(1,i);
    }

}
