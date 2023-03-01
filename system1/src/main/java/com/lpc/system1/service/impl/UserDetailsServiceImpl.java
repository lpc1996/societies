package com.lpc.system1.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lpc.system1.mapper.UserMapper;
import com.lpc.system1.model.LoginUser;
import com.lpc.system1.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @CreateTime 2023/2/21-19:03
 * @Author Administrator
 * @CreateBy IntelliJ IDEA
 * @Project societies
 */

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    PasswordEncoder passwordEncoder;
    @Resource
    UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("开始验证用户名和密码");
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName,username).last("limit 1");
        User user = userMapper.selectOne(queryWrapper);
        if(Objects.isNull(user)){
            throw new UsernameNotFoundException("用户名未发现");
        }
        LoginUser loginUser = new LoginUser(user);
//        loginUser.getAuthorities();
        return loginUser;
    }
}
