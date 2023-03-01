package com.lpc.system1.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lpc.system1.mapper.UserMapper;
import com.lpc.system1.model.LoginInfo;
import com.lpc.system1.model.LoginUser;
import com.lpc.system1.model.User;
import com.lpc.system1.model.response.ResponseMessage;
import com.lpc.system1.model.response.ResponseMessageEnum;
import com.lpc.system1.service.LoginService;
import com.lpc.system1.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Objects;

/**
 * @CreateTime 2023/2/27-22:16
 * @Author Administrator
 * @CreateBy IntelliJ IDEA
 * @Project societies
 */
@Slf4j
@Service
@Transactional
public class LoginServiceImpl extends ServiceImpl<UserMapper, User> implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public ResponseMessage login(LoginInfo loginInfo) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(
                        loginInfo.getUserName(),loginInfo.getPass());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        if(Objects.isNull(authentication)){
            throw new RuntimeException("认证失败");
        }
        //认证成功，生成token
        //获取用户信息（getPrincipal()）
        LoginUser loginUser = (LoginUser)authentication.getPrincipal();
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("userId", String.valueOf(loginUser.getUser().getId()));
        jwtUtils.setStoreData(hashMap);
        String token = jwtUtils.createToken();
        System.out.println(token);

        return ResponseMessage.newInstancec(ResponseMessageEnum.LOGIN_SUCCUSS,token);
    }
}
