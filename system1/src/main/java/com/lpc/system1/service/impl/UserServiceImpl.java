package com.lpc.system1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lpc.system1.mapper.UserMapper;
import com.lpc.system1.model.LoginInfo;
import com.lpc.system1.model.LoginUser;
import com.lpc.system1.model.User;
import com.lpc.system1.model.response.ResponseMessage;
import com.lpc.system1.model.response.ResponseMessageEnum;
import com.lpc.system1.service.UserService;
import com.lpc.system1.util.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Objects;

/**
 * @CreateTime 2023/2/22-23:04
 * @Author Administrator
 * @CreateBy IntelliJ IDEA
 * @Project societies
 */


@Slf4j
@Service
@Transactional
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Autowired
    private UserMapper userMapper;


    @Override
    public ResponseMessage insert(User user) {

        return userMapper.insert(user) == 1 ? ResponseMessage.
                newInstancec(ResponseMessageEnum.LOGIN_SUCCUSS):
                ResponseMessage.newInstancec(ResponseMessageEnum.LOGIN_FAIL);
    }
}
