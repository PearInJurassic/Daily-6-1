package com.daily.service;

import com.daily.dto.RegisterDTO;
import com.daily.entity.AdminAction;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testAdminFreezeUserById() {
         userService.adminFreezeUserById(1,1323);
    }

    @Test
    public void testAdminUnfreezeUserById(){
        userService.adminUnfreezeUserById(1,1324);
    }

    @Test
    public void testGetAdminAction(){
        List<AdminAction> actions = userService.getAdminAction();
        for(AdminAction a:actions){
            System.out.printf("%s %s %s %s %s\n",a.getActionId(),a.getActionType(),a.getAdminId(),a.getUserId(),a.getActionDate());
        }
    }

}
