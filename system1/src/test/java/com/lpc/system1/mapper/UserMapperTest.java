package com.lpc.system1.mapper;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.unit.DataUnit;
import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import com.lpc.system1.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.Date;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

/**
 * @CreateTime 2023/2/22-23:24
 * @Author Administrator
 * @CreateBy IntelliJ IDEA
 * @Project societies
 */

@MybatisPlusTest
@AutoConfigureTestDatabase(replace = NONE)
public class UserMapperTest{

    @Autowired
    private UserMapper userMapper;

    @Test
    void testInsert(){
        User user = new User();
        user.setUserName("旁观者");
        user.setNickName("-");
        user.setPass("123");
        user.setUType("ADMIN");
        user.setLastLoginDate(new Date());
        user.setCreateAt(DateUtil.date());
        user.setUpdateAt(DateUtil.date());
        System.out.println(userMapper.insert(user));
    }
}
