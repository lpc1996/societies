package com.lpc.system1;

import com.lpc.system1.model.User;
import com.lpc.system1.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@SpringBootTest
class System1ApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {

    }

    @Test
    void userInsertTest(){
        User user = new User();
        user.setUserName("旁观者");
        user.setNickName("-");
        user.setPass(new BCryptPasswordEncoder().encode("xx1602614lpc"));
        user.setUType("ADMIN");
        user.setLastLoginDate(new Date());
        System.out.println(userService.insert(user));
    }

}
